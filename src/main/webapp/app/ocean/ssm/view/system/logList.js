/**
 * @author haiyang.li on 2017/9/12.
 */
Ext.define('app.ocean.ssm.view.system.logList', {
    extend: 'Ext.panel.Panel',
    xtype: 'ssm-system-logList-xtype',
    itemId: 'ssm-system-logList-itemId',
    searchUrl: '/log/list',
    layout: 'fit',
    columns: [
        {text: 'id', dataIndex: 'id', flex: 1},
        {text: '模块', dataIndex: 'model', flex: 1},
        {text: '方法名', dataIndex: 'methodName', flex: 1},
        {text: '参数', dataIndex: 'arguments', flex: 1},
        {
            text: '是否访问成功', dataIndex: 'success', flex: 1, renderer: function (val) {
            return val ? '是' : '否';
        }
        }
    ],
    fields: [
        {type: 'string', name: 'id'},
        {type: 'string', name: 'model'},
        {type: 'string', name: 'methodName'},
        {type: 'string', name: 'arguments'},
        {type: 'boolean', name: 'success'}
    ],
    initComponent: function () {
        var me = this;
        var store = Ext.create("Ext.data.Store", {
            fields: me.fields,
            pageSize: 15,
            proxy: {
                type: 'ajax',
                url: app.ocean.ssm.common.request.url(me.searchUrl),
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
                xtype: 'gridpanel', border: true, columnLines: true,
                margin: "5 5 5 5", columns: me.columns, store: store,
                selModel: 'checkboxmodel',
                bbar: [{xtype: 'pagingtoolbar', displayInfo: true, store: store}],
                tbar: [{
                    xtype: 'button',
                    text: '删除',
                    glyph: 0xf014,
                    handler: function () {

                    }
                }, '->', {
                    xtype: 'button',
                    text: '查询',
                    glyph: 0xf002,
                    handler: function () {

                    }
                }]
            }]
        });
        this.callParent(arguments);
    }
});