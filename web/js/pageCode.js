/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
inicia = function () {
    var viewport = Ext.create('Ext.container.Viewport',
            {
                layout: 'absolute',
                items: [
                    {
                        xtype: 'panel',
                        title: 'miPanel A',
                        width: 300,
                        height: 300,
                        x: 100,
                        y: 200,
                        layout: 'absolute',
                        items: [
                            {
                                xtype: 'button',
                                text: 'Crear Ser Vivo',
                                x: 30,
                                y: 60,
                                handler: crearSerVivo
                            }, {
                                xtype: 'button',
                                text: 'Crear Nave',
                                x: 30,
                                y: 90,
                                handler: crearNave
                            }, {
                                xtype: 'button',
                                text: 'Listar Ser Vivo',
                                x: 30,
                                y: 120,
                                handler: listarSerVivo
                            }, {
                                xtype: 'button',
                                text: 'Listar Nave',
                                x: 30,
                                y: 150,
                                handler: listarNave
                            }
                        ]
                    }


                ]
            }
    );



};
var crearSerVivo = function () {
    if (Ext.getCmp("windowA") === undefined) {


        Ext.create('Ext.window.Window', {
            id: 'windowA',
            title: 'Crear Ser Vivo',
            height: 250,
            width: 400,
            bodyPadding: 10,
            renderTo: Ext.getBody(),
            layout: 'absolute',
            items: [{
                    xtype: 'textfield',
                    fieldLabel: 'Nombre',
                    id: 'textNombre',
                    x: 40,
                    y: 60
                }, {
                    xtype: 'textfield',
                    fieldLabel: 'Edad',
                    id: 'textEdad',
                    x: 40,
                    y: 90
                }, {
                    xtype: 'textfield',
                    fieldLabel: 'respuesta',
                    id: 'textRespuesta',
                    x: 40,
                    y: 120
                }, {
                    xtype: 'button',
                    text: 'Click me',
                    x: 260,
                    y: 160,
                    handler: function () {
                        //Ext.getCmp('windowA').setHeight(500);
                        Ext.Ajax.request({
                            url: 'http://localhost:8080/ProgramaInicialWeb1/webresources/realidad/interface1/bloque1',
                            method: 'GET',
                            params: {
                                nombre: Ext.getCmp('textNombre').getValue(),
                                edad: Ext.getCmp('textEdad').getValue()
                            },
                            success: function (response, opts) {

                                Ext.getCmp('textRespuesta').setValue(response.responseText);
                                var obj = Ext.decode(response.responseText);
                                alert(obj.valor1);
//                                if (obj.valor1 === 'Rebeca') {
//                                    Ext.getCmp('windowB').show();
//                                }
                            },
                            failure: function (response, opts) {
                                alert("Fallo [" + response.status + "]");
                            }

                        });
                    }
                }],
            maximizable: true
        }
        );
        Ext.getCmp("windowA").show();
    }
};

var crearNave = function () {
    if (Ext.getCmp("windowB") === undefined) {
        Ext.create('Ext.window.Window', {
            id: 'windowB',
            title: 'Crear Nave',
            height: 250,
            width: 400,
            bodyPadding: 10,
            renderTo: Ext.getBody(),
            layout: 'absolute',
            items: [{
                    xtype: 'textfield',
                    fieldLabel: 'Tipo Nave',
                    id: 'textTipoNave',
                    x: 40,
                    y: 60
                }, {
                    xtype: 'textfield',
                    fieldLabel: 'Nombre Nave',
                    id: 'textNombreNave',
                    x: 40,
                    y: 90

                },
                {
                    xtype: 'textfield',
                    fieldLabel: 'Respuesta Nave',
                    id: 'textRespuestaNave',
                    x: 40,
                    y: 120
                }, {
                    xtype: 'button',
                    text: 'Click me',
                    x: 260,
                    y: 170,
                    handler: function () {
                        //Ext.getCmp('windowA').setHeight(500);
                        Ext.Ajax.request({
                            url: 'http://localhost:8080/ProgramaInicialWeb1/webresources/realidad/interface1/bloque2',
                            method: 'GET',
                            params: {
                                tipoNave: Ext.getCmp('textTipoNave').getValue(),
                                nombreNave: Ext.getCmp('textNombreNave').getValue()
                            },
                            success: function (response, opts) {

                                Ext.getCmp('textRespuestaNave').setValue(response.responseText);
                                var obj = Ext.decode(response.responseText);
                                alert(obj.valor1);
//                                if (obj.valor1 === 'Rebeca') {
//                                    Ext.getCmp('windowA').show();
//                                }
                            },
                            failure: function (response, opts) {
                                alert("Fallo [" + response.status + "]");
                            }

                        });
                    }
                }],
            maximizable: true
        }
        );
        Ext.getCmp("windowB").show();
    }
};

var listarSerVivo = function () {};
var listarNave = function () {};
Ext.onReady(inicia);