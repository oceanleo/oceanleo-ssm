Ext.define('app.ocean.ssm.view.main.main', {
    extend: 'Ext.Viewport',
    layout: 'border',
    requires: ['app.ocean.ssm.common.request'],
    initComponent: function () {
        var me = this;
        Ext.applyIf(this, {
            items: [{
                region: "north",
                itemId: 'maintop',
                height: 40,
                margin: '10 0 0 0',
                padding: '0px',
                collapsible: false,
                xtype: 'toolbar',
                border: false,
                layout: "auto",
                items: [{
                    xtype: "image",
                    src: "img/extjs5.png",
                    cls: "main-logo"
                }, {
                    xtype: "image",
                    src: "img/mainLogo.png",
                    cls: "main-logo"
                }, {
                    xtype: "container",
                    cls: "top-tool",
                    items: [{
                        xtype: "label",
                        itemId:'welcome',
                        html: ''
                    }, {
                        xtype: 'button',
                        glyph: 0xf011,
                        text: '退出',
                        // border: false,
                        handler: function () {
                            me.logout();
                        }
                    }]
                }]
            }, {
                itemId: 'mainbottom',
                xtype: 'toolbar',
                region: 'south',
                height: 40,
                listeners: {
                    afterRender: function (cmp) {
                        var qtip = "<div style='color: gray;'><span style='font-weight: bold;margin-left: 10px;'>登录账号</span>:" + window.Context.user.username +"</div>";
                        cmp.queryById("qtip").setHtml(qtip);

                        var welcome = "<span style='font-weight: bold;margin-left: 10px;color: orangered'>Hi&nbsp;</span>,&nbsp;" + window.Context.user.name;
                        me.queryById("welcome").setHtml(welcome);
                    }
                },
                items: [{
                    itemId: "qtip",
                    width: "100%",
                    xtype: 'displayfield'
                }]
            }, {
                region: "west",
                border: true,
                padding: '0px',
                split: true,
                margin: '0',
                collapsible: true,
                collapsed: false,
                xtype: 'treepanel',
                title: '功能菜单',
                width: 200,
                store: this.createMenuStore(),
                listeners: {
                    scope: this,
                    itemClick: function (source, record, item, index, e, eOpts) {
                        me.openView(record.data.text, record.data.url);
                    }
                }
            }, {
                itemId: 'centerBox',
                region: "center",
                layout: 'fit',
                border: true,
                margin: '0 0 0 0',
                collapsible: false,
                xtype: 'tabpanel',
                items: []
            }]
        });
        this.callParent(arguments);
    },

    createMenuStore: function () {
        var navStore = Ext.create("Ext.data.TreeStore", {
            autoLoad: true,
            defaultExpandAll: false,
            rootVisible: true,
            proxy: {
                type: "ajax",
                reader: "json",
                url: app.ocean.ssm.common.request.url("/menu2.json")
            }
        });
        var menuStore = Ext.create("Ext.data.Store", {
            autoLoad: true,
            fields: [
                {type: 'string', name: 'id'},
                {type: 'string', name: 'name'},
                {type: 'string', name: 'url'}
            ],
            proxy: {
                type: "ajax",
                url: app.ocean.ssm.common.request.url("/user/getAllMenu"),
                reader:{
                    type: 'json',
                    root: 'resultData'
                }
            }
        });
        //var store = Ext.create("Ext.data.Store", {
        //    autoLoad: true,
        //    proxy: {
        //        type: "ajax",
        //        reader: "json",
        //        url: app.ocean.ssm.common.request.url("/user/getAll")
        //    }
        //});
        return navStore;
        //var data;
        //try{
        //    data = app.ocean.ssm.common.request.request({id: 1}, '/user/getById');
        //    return data;
        //}catch (e){
        //    Ext.Msg.alert('温馨提示',e.message);
        //}
        //var sidebarUrl = app.platform.shfs.common.RequestUtils.url("/dashboard/sidebar");
        //if(window.Context.platform.model!=''){
        //    sidebarUrl = sidebarUrl+"?m="+window.Context.platform.model;
        //}
        //var longNameFilter = new Ext.util.Filter({
        //    filterFn:function(item) {
        //        var level = item.data.nodeLevel;
        //        if(level){
        //            level = level.trim();
        //            if(!isNaN(level)){
        //                if(parseInt(level)>=3)
        //                    return false;
        //                else if(parseInt(level)==2){
        //                    item.data.leaf = true;
        //                }
        //            }
        //        }
        //        return true;
        //    }
        //});
        //return Ext.create('Funi.data.TreeStore', {
        //    url: sidebarUrl,
        //    autoLoad: true,
        //    defaultExpandAll: false,
        //    defaultRootProperty: "children",
        //    fields: [{
        //        name: 'text',
        //        mapping: 'name'
        //    }],
        //    filters:longNameFilter
        //});
        //return null;
    },

    logout: function () {
        var action = Ext.create('Ext.form.Basic', this, {
            standardSubmit: true
        });

        action.submit({
            url: app.ocean.ssm.common.request.url("/security_logout"),
            clientValidation: false
        });
    },

    /**
     * 打开一个新视图
     * @param viewClsName @type String 视图类名称
     * @param config 视图配置
     * @param onlyOne @type boolean 是否仅允许单实例，默认false
     * @return 打开的视图对象
     */
    openView: function (viewClsName, url, config) {
        config = config || {};
        if (url) {
            //取得视图
            var urlPatterns = url.split("?");
            var view = urlPatterns[1].replace("viewName=", "");
            try {
                //Funi.core.Dashboard.newTab({title: viewClsName, view: view});
                this.createTab({title: viewClsName, view: view});
            } catch (e) {
                Ext.Msg.alert('温馨提示','视图加载错误！');
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
                    viewId = opts.view + (opts.title ? opts.title : "");
                } else if (opts.view.id) {
                    //如果是对象且ID存在，则ID+试图名称生成ID
                    viewId = opts.view.id + (opts.title ? opts.title : (opts.view.title ? opts.view.title : ""));
                }
            }

            if (opts.feature) {
                viewId = viewId + feature;
            }
            return viewId;
        }

        var tabId = "tab_" + getViewId(opts);
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
            /**
             * 如果传入的是视图名称则创建视图
             */
            if (typeof opts.view == 'string') {
                contentView = Ext.create(opts.view, {params: (opts.params ? opts.params : {})});
            }
            /**
             * 如果视图已经是对象且，且ID已经存在，则直接作为视图内容生成
             */
            if (typeof opts.view == 'object' && opts.view.id) {
                contentView = opts.view;
            }
            if (contentView != null) {
                tab.add(contentView);
                Ext.mainFrame.getComponent("centerBox").add(tab);
            }

        }
        Ext.mainFrame.getComponent("centerBox").setActiveTab(tab);
    }
});