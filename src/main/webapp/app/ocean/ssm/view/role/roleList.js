/**
 * @author haiyang.li on 2017/9/12.
 */
Ext.define('app.ocean.ssm.view.role.roleList', {
    extend: 'Ext.panel.Panel',
    xtype: 'ssm-role-roleList-xtype',
    itemId: 'ssm-role-roleList-itemId',
    searchUrl: '/role/list',
    layout: 'fit',
    columns: [
        {text: '角色id', dataIndex: 'id', flex: 1},
        {text: '角色名称', dataIndex: 'roleName', flex: 1},
        {text: '角色编码', dataIndex: 'roleCode', flex: 1}
    ],
    fields: [
        {type: 'string', name: 'id'},
        {type: 'string', name: 'roleName'},
        {type: 'string', name: 'roleCode'}
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
                    text: '添加角色'
                }]
            }]
        });
        this.callParent(arguments);
    }
});