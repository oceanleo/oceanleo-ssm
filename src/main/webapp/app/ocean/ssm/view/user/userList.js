/**
 * @author haiyang.li on 2017/9/12.
 */
Ext.define('app.ocean.ssm.view.user.userList', {
    extend: 'Ext.panel.Panel',
    xtype: 'ssm-user-userList-xtype',
    itemId: 'ssm-user-userList-itemId',
    searchUrl: '/user/getAll',
    layout: 'fit',
    columns: [
        {text: '用户名', dataIndex: 'username', flex: 1},
        {text: '年龄', dataIndex: 'age', flex: 1},
        {text: '姓名', dataIndex: 'name', flex: 1}
    ],
    fields: [
        {type: 'string', name: 'username'},
        {type: 'number', name: 'age'},
        {type: 'string', name: 'name'}
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
                    totalProperty:'resultData.total'
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
                columns: columnsObj,
                store: store,
                bbar: [
                    {xtype: 'pagingtoolbar', displayInfo: true, height: "auto", store: store}
                ],
                tbar:[{
                    xtype:'button',
                    text:'添加账户'
                }]
            }]
        });
        this.callParent(arguments);
    }
});