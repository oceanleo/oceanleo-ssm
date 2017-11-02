Ext.define('app.ocean.ssm.view.main.main', {
    extend: 'Ext.Viewport',
    layout: 'border',
    requires: ['app.ocean.ssm.common.request'],
    initComponent: function () {
        var me = this;
        Ext.applyIf(this, {
            items: [{
                region: 'north', xtype: 'toolbar', itemId: 'maintop', height: 40,
                padding: '0px', collapsible: false, border: false, layout: 'hbox',
                items: [{
                    xtype: 'image', src: 'img/extjs5.png', height: 30, width: 120, margin: '5'
                }, {
                    xtype: 'image', src: 'img/mainLogo.png', height: 30, width: 550, margin: '5 0'
                },
                    '->', '->', '->', '->', '->', '->', '->', '->', '->', '->', '->', '->', '->', '->', '->', '->', '->', '->', '->', '->', '->', '->', '->', '->', '->', '->',
                    '->', '->', '->', '->', '->', '->', '->', '->', '->', '->', '->', '->', '->', '->', '->', '->', '->', '->', '->', '->', '->', '->', '->', '->', '->', '->',
                    {
                        xtype: 'container', height: 40, width: '100%', layout: 'hbox',
                        items: [{
                            xtype: 'label', itemId: 'top-welcome', height: 20, html: '', margin: '20 2 0 0'
                        }, {
                            xtype: 'button', height: 20, glyph: 0xf090, text: '退出', margin: '16 2 0 2', border: false,
                            handler: function () {
                                me.logout();
                            }
                        }, {
                            xtype: 'button', height: 20, glyph: 0xf023, text: '密码', margin: '16 2 0 2', border: false,
                            handler: function () {
                                me.logout();
                            }
                        }, {
                            xtype: 'button', height: 20, glyph: 0xf085, text: '主题', margin: '16 2 0 2', border: false,
                            handler: function () {
                                me.logout();
                            }
                        }]
                    }]
            }, {
                itemId: 'mainbottom', xtype: 'toolbar', region: 'south', height: 30, width: '100%', margin: '2 0 0 0',
                listeners: {
                    afterRender: function (cmp) {
                        var bottom_welcome = "<div style='color: gray;'><span style='font-weight: bold'>登录账号</span>:" + window.Context.user.username + '</div>';
                        cmp.queryById('bottom-welcome').setHtml(bottom_welcome);

                        var top_welcome = "<span style='font-weight: bold;margin-left: 0px;color: red'>Hi&nbsp;</span>" + window.Context.user.name;
                        me.queryById('top-welcome').setHtml(top_welcome);
                    }
                },
                items: [{
                    xtype: 'displayfield', itemId: 'bottom-welcome'
                }]
            }, {
                region: 'west', border: true, padding: '0px',
                split: true, margin: '0', collapsible: true, collapsed: false,
                xtype: 'treepanel', title: '功能菜单', width: 200, store: this.createMenuStore(),
                listeners: {
                    scope: this,
                    itemClick: function (source, record, item, index, e, eOpts) {
                        me.openView(record.data.text, record.data.url);
                    }
                }
            }, {
                itemId: 'centerBox', region: 'center', layout: 'fit',
                border: true, margin: '0 0 0 0', collapsible: false, xtype: 'tabpanel',
                items: []
            }]
        });
        this.callParent(arguments);
    },
    createMenuStore: function () {
        var navStore = Ext.create('Ext.data.TreeStore', {
            autoLoad: true,
            defaultExpandAll: false,
            rootVisible: true,
            proxy: {
                type: 'ajax',
                reader: 'json',
                url: app.ocean.ssm.common.request.url('/menu2.json')
            },
            root: {
                expanded: true,
                text: '个人开发测试'
            }
        });
        return navStore;
    },
    logout: function () {
        var action = Ext.create('Ext.form.Basic', this, {
            standardSubmit: true
        });
        action.submit({
            url: app.ocean.ssm.common.request.url('/security_logout'),
            clientValidation: false
        });
    },
    //打开一个新视图
    openView: function (viewClsName, url, config) {
        config = config || {};
        if (url) {
            //取得视图
            var urlPatterns = url.split('?');
            var view = urlPatterns[1].replace('viewName=', '');
            try {
                //Funi.core.Dashboard.newTab({title: viewClsName, view: view});
                this.createTab({title: viewClsName, view: view});
            } catch (e) {
                Ext.Msg.alert('温馨提示', '视图加载错误！');
            }
        }
    },
    createTab: function (opts) {
        function getViewId(opts) {
            var viewId;
            if (opts.viewId) {
                viewId = (typeof (opts.viewId) == 'function') ? opts.viewId() : opts.viewId;
            } else {
                //如果只是简单地视图路径则直接拼接生成视图ID
                if (typeof opts.view == 'string') {
                    viewId = opts.view + (opts.title ? opts.title : '');
                } else if (opts.view.id) {
                    //如果是对象且ID存在，则ID+试图名称生成ID
                    viewId = opts.view.id + (opts.title ? opts.title : (opts.view.title ? opts.view.title : ''));
                }
            }
            if (opts.feature) {
                viewId = viewId + feature;
            }
            return viewId;
        }

        var tabId = 'tab_' + getViewId(opts);
        var tab = Ext.getCmp(tabId);
        if (tab == null) {
            //新建选项卡页
            tab = Ext.create({
                id: tabId,
                title: opts.title,
                xtype: 'container',
                scrollable: false,
                closable: true,
                layout: 'fit'
            });
            var contentView;
            //如果传入的是视图名称则创建视图
            if (typeof opts.view == 'string') {
                contentView = Ext.create(opts.view, {params: (opts.params ? opts.params : {})});
            }
            //如果视图已经是对象且，且ID已经存在，则直接作为视图内容生成
            if (typeof opts.view == 'object' && opts.view.id) {
                contentView = opts.view;
            }
            if (contentView != null) {
                tab.add(contentView);
                Ext.mainFrame.getComponent('centerBox').add(tab);
            }
        }
        Ext.mainFrame.getComponent('centerBox').setActiveTab(tab);
    }
});