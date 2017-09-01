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
                        html: "<i class='icon-user'></i> 欢迎您,ocean木子 "
                    }, {
                        xtype: 'button',
                        //glyph: 0xf011,
                        text: '退出',
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
                listeners: {},
                items: []
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
                store: this.__createMenuStore(),
                listeners: {
                    //scope: this,
                    //itemclick: function (source, record, item, index, e, eOpts) {
                    //    me.__openIframeView(record.data.text, record.data.url);
                    //}
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

    __createMenuStore: function () {
        var navStore = Ext.create("Ext.data.TreeStore", {
            autoLoad: true,
            defaultExpandAll: false,
            rootVisible:true,
            proxy: {
                type: "ajax",
                reader: "json",
                url: app.ocean.ssm.common.request.url("/menu2.json")
            }
        });
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
    __openIframeView: function (viewClsName, url, config) {
        config = config || {};
        if (url != '') {
            //取得视图
            var urlPatterns = url.split("?");
            var view = urlPatterns[1].replace("viewName=", "");
            try {
                //Funi.core.Dashboard.newTab({title: viewClsName, view: view});
            } catch (e) {
                //Funi.core.Dashboard.error({message: "视图加载错误"});
            }
        }

    }
});