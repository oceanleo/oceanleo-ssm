/**
 * @author haiyang.li on 2017/9/12.
 */
Ext.define('app.ocean.ssm.view.system.menuList', {
    extend: 'Ext.panel.Panel',
    xtype: 'ssm-system-menuList-xtype',
    itemId: 'ssm-system-menuList-itemId',
    searchUrl: '/menu/list',
    layout: 'fit',
    columns: [
        {text: 'id', dataIndex: 'id', flex: 1},
        {text: '名称', dataIndex: 'name', flex: 1},
        {text: '链接', dataIndex: 'url', flex: 1},
        {text: '编码', dataIndex: 'code', flex: 1},
        {text: '排序', dataIndex: 'sort', flex: 1},
        {text: '上次菜单名称', dataIndex: 'parentName', flex: 1}
    ],
    fields: [
        {type: 'string', name: 'id'},
        {type: 'string', name: 'name'},
        {type: 'string', name: 'url'},
        {type: 'string', name: 'code'},
        {type: 'number', name: 'sort'},
        {type: 'string', name: 'parentName'}
    ],
    initComponent: function () {
        var me = this;
        var columnsObj = me.columns;
        var fieldsObj = me.fields;
        var url = me.searchUrl;
        var store = Ext.create("Ext.data.Store", {
            fields: fieldsObj,
            pageSize: 15,
            proxy: {
                type: 'ajax',
                url: app.ocean.ssm.common.request.url(url),
                reader: {
                    type: 'json',
                    rootProperty: 'resultData.list',
                    totalProperty: 'resultData.total'
                }
            },
            autoLoad: true
        });
        Ext.applyIf(me, {
            items: [{
                xtype: 'gridpanel',
                border: true,
                columnLines: true,
                overflowY: 'auto',
                width: "100%",
                margin: "5 5 5 5",
                columns: columnsObj,
                store: store,
                bbar: [
                    {xtype: 'pagingtoolbar', displayInfo: true, height: "auto", store: store}
                ],
                tbar: [{
                    xtype: 'button',
                    text: '添加菜单',
                    glyph: 0xf0fe
                }]
            }]
        });
        this.callParent(arguments);
    }
});