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
                    xtype: 'button', text: '添加角色', glyph: 0xf0fe,
                    handler: function () {
                        var win = Ext.create('Ext.Window', {
                            title: '上传文件', width: 400, height: 450, modal: true, glyph: 0xf07c,
                            itemId: 'ssm-system-roleList-add-itemId',
                            items: [{
                                xtype: 'form', layout: 'fit', margin: '10 50 0 50',
                                items: [{
                                    xtype: 'filefield', itemId: 'ssm-system-roleList-upload-itemId',
                                    name: 'uploadFile', width: 150, labelWidth: 50, fieldLabel: '文件', buttonText: '选择文件'
                                }]
                            }, {
                                xtype: 'box', itemId: 'ssm-system-roleList-preview-itemId',
                                id: 'imagePreview', border: true, height: 300, width: 300, margin: '10 50 0 50',
                                autoEl: {
                                    tag: 'img',
                                    src: app.ocean.ssm.common.request.url('/file/download')
                                }
                            }],
                            buttons: [{
                                text: '上传',
                                glyph: 0xf093,
                                handler: function () {
                                    var formObj = this.up('window').down('form');
                                    var form = formObj.getForm();
                                    if (form.isValid()) {
                                        form.submit({
                                            type: 'ajax',
                                            method: 'post',
                                            url: app.ocean.ssm.common.request.url('/file/upload'),
                                            waitMsg: '文件上传中，请稍等...',
                                            success: function (form, action) {
                                                var data = action.result;
                                                Ext.get('imagePreview').dom.src = app.ocean.ssm.common.request.url('/file/download?fileId=' + data.fileId);
                                                Ext.Msg.alert('温馨提示', '上传成功!');
                                                // formObj.up('window').close();
                                            },
                                            failure: function (form, action) {
                                                Ext.Msg.alert('温馨提示', action.result.message);
                                            }
                                        });
                                    }
                                }
                            }, {
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