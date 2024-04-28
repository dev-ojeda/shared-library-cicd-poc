#!/usr/bin/env groovy
package com.builder.template

import com.builder.util.Mock
public class Menu {

    def inicio(){
        properties([
                parameters([
                [
                    $class: 'ChoiceParameter', 
                    choiceType: 'PT_SINGLE_SELECT', 
                    filterLength: 1, 
                    filterable: false, 
                    name: 'Tipo', 
                    script: 
                    [
                        $class: 'GroovyScript', 
                        fallbackScript: 
                        [
                            classpath: [], 
                            sandbox: true, 
                            script: ''
                        ], 
                        script: 
                        [
                            classpath: [], 
                            sandbox: true, 
                            script: choiceTipo()
                        ]
                    ]
                ], 
                [
                    $class: 'ChoiceParameter', 
                    choiceType: 'PT_SINGLE_SELECT', 
                    filterLength: 1, 
                    filterable: false, 
                    name: 'Geos', 
                    script: 
                    [
                        $class: 'GroovyScript', 
                        fallbackScript: 
                        [
                            classpath: [], 
                            sandbox: true, 
                            script: ''
                        ], 
                        script: 
                        [
                            classpath: [], 
                            sandbox: true, 
                            script: choiceGeo()
                        ]
                    ]
                ], 
                [
                    $class: 'DynamicReferenceParameter', 
                    choiceType: 'ET_FORMATTED_HTML', 
                    name: 'Lookups', 
                    omitValueField: false, 
                    referencedParameters: 'Tipo,Geos', 
                    script: 
                    [
                        $class: 'GroovyScript', 
                        fallbackScript: 
                        [
                            classpath: [], 
                            sandbox: true, 
                            script: ''
                        ], 
                        script: 
                        [
                            classpath: [], 
                            sandbox: true, 
                            script: choiceDominioPorGeo(this.params.Tipo,this.params.Geos)
                        ]
                    ]
                ]
            ])
        ])
    }

    static def choice_tipo(){
        return Mock.lista_tipo()
    }

    static def choice_geo(){
        return Mock.lista_geo()
    }

    static def choice_dominio_por_geo(Object tipo, Object geo){
        return Mock.lista_dominio_por_geo(tipo, geo)
    }
}