Ext.define('app.ocean.ssm.view.main.main', {
    extend: 'Ext.Viewport',
    layout: 'border',
    requires: ['app.ocean.ssm.common.request'],
    autoRefreshStarted: false,
    initComponent: function () {
        var me = this;
        Ext.applyIf(this, {
            listeners: {
                afterRender: function (cmp) {
                    var bottom_welcome = "<div style='color: gray;'><span style='font-weight: bold'>登录账号：</span>&nbsp;&nbsp;" + window.Context.user.username + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "</div>";
                    me.queryById('bottom-welcome').setHtml(bottom_welcome);
                    var top_welcome = "<span style='font-weight: bold;margin-left: 1px;color: red'>Hello &nbsp;</span>" + window.Context.user.name;
                    me.queryById('top-welcome').setHtml(top_welcome);
                    if (!cmp.autoRefreshStarted) {
                        var task = {
                            run: function () {
                                var bottom_time = "<div style='color: gray;'>" + "<span style='font-weight: bold'>当前时间：</span> &nbsp; &nbsp;" + Ext.Date.format(new Date(), 'Y-m-d H:i:s') + "</div>";
                                me.queryById('bottom-time').setHtml(bottom_time);
                            },
                            interval: 1000
                        };
                        Ext.util.TaskManager.start(task);
                        cmp.autoRefreshStarted = true;
                    }
                }
            },
            items: [{
                region: 'north', xtype: 'toolbar', itemId: 'maintop', height: 40,
                padding: '0px', collapsible: false, border: false, layout: 'hbox',
                items: [{
                    xtype: 'container', height: 40,
                    items: [{
                        xtype: 'image', src: 'img/extjs5.png', height: 30, width: 120, margin: '5'
                    }, {
                        xtype: 'image', src: 'img/mainLogo.png', height: 30, width: 550, margin: '5 0'
                    }]
                }, '->', {
                    xtype: 'label', itemId: 'top-welcome', height: 15, html: '', margin: '25 10 0 0'
                }, {
                    xtype: 'button', glyph: 0xf085, text: '主题', border: false,
                    handler: function () {
                        var win = Ext.create('Ext.Window', {
                            title: '切换主题', width: 300, height: 150, modal: true, glyph: 0xf181,
                            items: [{
                                xtype: 'combo', labelWidth: 30, margin: '25 50', fieldLabel: '主题', emptyText: '请选择主题',
                                displayField: 'text', valueField: 'value', editable: false,
                                store: Ext.create('Ext.data.Store', {
                                    data: [
                                        {text: 'aria', value: 'aria'},
                                        {text: 'classic', value: 'classic'},
                                        {text: 'crisp', value: 'crisp'},
                                        {text: 'gray', value: 'gray'},
                                        {text: 'neptune', value: 'neptune'},
                                        {text: 'triton', value: 'triton'}
                                    ],
                                    fields: ['text', 'value']
                                }),
                                listeners: {
                                    change: function (combo, newValue, oldValue, eOpts) {
                                        me.changeTheme(oldValue, newValue);
                                    }
                                }
                            }],
                            buttons: [{
                                text: '确定', glyph: 0xf00c,
                                handler: function () {
                                    var comboObj = this.up('window').down('combo');
                                    var val = comboObj.value;
                                    Ext.Msg.alert('温馨提示', val);
                                }
                            }, {
                                text: '取消', glyph: 0xf00d,
                                handler: function () {
                                    this.up('window').close();
                                }
                            }]
                        });
                        win.show();
                    }
                }, {
                    xtype: 'button', glyph: 0xf023, text: '修改密码', border: false,
                    handler: function () {
                        var win = Ext.create('Ext.Window', {
                            title: '修改密码', width: 400, height: 230, modal: true, glyph: 0xf023,layout: 'fit',border: true,
                            items: [{
                                xtype: 'form', margin: '20 20',
                                items: [{
                                    xtype: 'splitter'
                                }, {
                                    xtype: 'textfield', inputType: 'password', fieldLabel: '旧密码', labelAlign: 'right',
                                    name: 'oldPassword', allowBlank: false, width: 320, labelWidth: 80, emptyText: '请输入旧密码'
                                }, {
                                    xtype: 'splitter'
                                }, {
                                    xtype: 'textfield', inputType: 'password', fieldLabel: '新密码', labelAlign: 'right', vtype: 'same',
                                    name: 'newPassword', allowBlank: false, width: 320, labelWidth: 80, emptyText: '请输入新密码'
                                }, {
                                    xtype: 'splitter'
                                }, {
                                    xtype: 'textfield', inputType: 'password', fieldLabel: '确认新密码', labelAlign: 'right', vtype: 'repetition',
                                    name: 'repetitionPassword', allowBlank: false, width: 320, labelWidth: 80, emptyText: '确认新密码'
                                }]
                            }],
                            buttons: [{
                                text: '确定', glyph: 0xf00c,
                                handler: function () {
                                    var formObj = this.up('window').down('form');
                                    if(formObj.isValid()){
                                        var formData = formObj.getValues();
                                        var params = {oldPassword:formData.oldPassword, newPassword:formData.newPassword};
                                        try{
                                            app.ocean.ssm.common.request.request(params,'/user/update/password');
                                            formObj.up('window').close();
                                            Ext.Msg.alert({title: '温馨提示', msg: '修改成功', icon: Ext.Msg.OK, buttons:Ext.Msg.OK});
                                            me.logout();
                                        } catch (e){
                                            Ext.Msg.alert({title: '温馨提示', msg: e.message, icon: Ext.Msg.ERROR, buttons:Ext.Msg.OK});
                                        }
                                    }
                                }
                            }, {
                                text: '取消', glyph: 0xf00d,
                                handler: function () {
                                    this.up('window').close();
                                }
                            }]
                        });
                        win.show();
                    }
                }, {
                    xtype: 'button', glyph: 0xf090, text: '退出', border: false,
                    handler: function () {
                        me.logout();
                    }
                }, {
                    xtype: 'button',glyph: 0xf059, text: '帮助', border: false,
                    handler: function () {
                        var win = Ext.create('Ext.Window', {
                            title: '帮助', width: 400, height: 300, modal: true, glyph: 0xf059,
                            items: [{}],
                            buttons: [{
                                text: '确定', glyph: 0xf00c,
                                handler: function () {
                                    this.up('window').close();
                                }
                            }]
                        });
                        win.show();
                    }
                }, {
                    xtype: 'button',glyph: 0xf06a, text: '关于', border: false,
                    handler: function () {
                        var win = Ext.create('Ext.Window', {
                            title: '关于', width: 400, height: 300, modal: true, glyph: 0xf06a,
                            items: [{}],
                            buttons: [{
                                text: '确定', glyph: 0xf00c,
                                handler: function () {
                                    this.up('window').close();
                                }
                            }]
                        });
                        win.show();
                    }
                }, {
                    xtype: 'button',glyph: 0xf102, tooltip: '隐藏顶部和底部区域', border: false,
                    handler: function () {
                        me.hiddenTopBottom();
                    }
                }]
            }, {
                itemId: 'mainbottom', xtype: 'toolbar', region: 'south', height: 30, width: '100%', margin: '2 0 0 0',
                items: [{
                    xtype: 'displayfield', itemId: 'bottom-welcome'
                }, {
                    xtype: 'displayfield', itemId: 'bottom-time'
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
    updatePassword: function () {

    },
    changeTheme: function (oldTheme, newTheme) {
        if (oldTheme && newTheme) {
            // var myHead = document.getElementsByTagName('HEAD').item(0);
            // var cssList = document.getElementsByTagName('link');
            // Ext.iterate(cssList, function (item) {
            //     if (item.href.indexOf(oldTheme) != -1) {
            //         myHead.removeChild(item);
            //         return false;
            //     }
            // });
            // var scriptList = document.getElementsByTagName('script');
            // Ext.iterate(scriptList, function (item) {
            //     if (item.src.indexOf(oldTheme) != -1) {
            //         myHead.remove(item);
            //         return false;
            //     }
            // });
            // var cssSrc = 'http://localhost:8080/ssm/ext/build/packages/theme-' + newTheme + '/resources/theme-' + newTheme + '-all.css';
            // var themeCss = document.createElement('link');
            // themeCss.type = 'text/css';
            // themeCss.src = cssSrc;
            // myHead.appendChild(themeCss);
            // var jsSrc = 'http://localhost:8080/ssm/ext/build/packages/theme-' + newTheme + '/theme-' + newTheme + '.js';
            // var themeJs = document.createElement('script');
            // themeJs.type = 'text/javascript';
            // themeJs.src = jsSrc;
            // myHead.appendChild(themeJs);
        }
    },
    hiddenTopBottom: function () {
        var me = this;
        // 如果要操纵控件，最好的办法是根据相对路径来找到该控件，用down或up最好，尽量少用getCmp()函数。
        me.getComponent("maintop").hide();
        me.getComponent("mainbottom").hide();
        // 显示顶部和底部的一个控件，在顶部和底部隐藏了以后，显示在页面的最右上角
        if (!this.showButton) {
            this.showButton = Ext.widget('component', {
                glyph: 0xf103,
                view: this,
                floating: true,
                x: document.body.clientWidth - 32,
                y: 0,
                height: 6,
                width: 26,
                style: 'background-color:#d0aa58',
                listeners: {
                    el: {
                        click: function (el) {
                            var c = Ext.getCmp(el.target.id); // 取得component的id值
                            me.getComponent("maintop").show();
                            me.getComponent("mainbottom").show();
                            c.hide();
                        }
                    }
                }
            })
        }
        this.showButton.show();
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


Ext.apply(Ext.form.field.VTypes, {
    repetition: function (val, field) {
        var formObj = field.up('form');
        var formValues = formObj.getValues();
        if(formValues.newPassword && formValues.repetitionPassword){
            return formValues.newPassword == formValues.repetitionPassword;
        }
        return false;
    },
    repetitionText: '新密码不一致',
    same: function (val, field) {
        var formObj = field.up('form');
        var formValues = formObj.getValues();
        if (formValues.newPassword && formValues.oldPassword){
            return formValues.newPassword != formValues.oldPassword;
        }
        return false;
    },
    sameText:'新密码不能和旧密码相同'
});