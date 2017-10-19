/**
 * @author haiyang.li on 2017/9/12.
 */
Ext.define('app.ocean.ssm.view.system.roleList', {
    extend: 'Ext.panel.Panel',
    xtype: 'ssm-system-roleList-xtype',
    itemId: 'ssm-system-roleList-itemId',
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
        var store = Ext.create('Ext.data.Store', {
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
                xtype: 'gridpanel', border: true, columnLines: true, overflowY: 'auto',
                width: '100%', margin: '5 5 5 5', columns: columnsObj, store: store,
                bbar: [
                    {xtype: 'pagingtoolbar', displayInfo: true, height: 'auto', store: store}
                ],
                tbar: [{
                    xtype: 'button', text: '添加角色',
                    handler:function () {
                        var win = Ext.create('Ext.Window', {
                            title:'上传文件',
                            width:400,
                            height:200,
                            modal:true,
                            itemId: 'sh-itemId-netContract-com-upload',
                            items: {
                                xtype: 'form',
                                layout:'fit',
                                margin: '50 50 0 50',
                                items:[{
                                    fieldLabel: '文件',
                                    xtype: 'filefield',
                                    name: 'uploadFile',
                                    width:150,
                                    buttonText: '选择文件',
                                    labelWidth: 50
                                }],
                                listeners: {
                                    afterUpload: function (returnData) {
                                        if (returnData) {
                                            Ext.Msg.alert('温馨提示','上传成功后!!!');
                                        }
                                    }
                                }
                            },
                            buttons:[{
                                text: '上传',
                                glyph: 'xf093@FontAwesome',
                                handler: function () {
                                    var formObj = this.up('window').down('form');
                                    var form = formObj.getForm();
                                    if (form.isValid()) {
                                        form.submit({
                                            type:'ajax',
                                            method: 'post',
                                            url: app.ocean.ssm.common.request.url('/file/upload'),
                                            waitMsg: '文件上传中，请稍等...',
                                            success: function (form, action) {
                                                var data = action.result;
                                                formObj.fireEvent('afterUpload', data);
                                                Ext.Msg.alert('温馨提示','上传成功!');
                                                formObj.up('window').close();
                                            },
                                            failure: function (form, action) {
                                                Ext.Msg.alert('温馨提示', action.result.message);
                                            }
                                        });
                                    }
                                }
                            },{
                                text: '取消',
                                glyph: 0xf00d,
                                handler: function () {
                                    this.up('window').close();
                                }
                            }]
                        });
                        win.show();
                    }
                }]
            }]
        });
        this.callParent(arguments);
    }
});