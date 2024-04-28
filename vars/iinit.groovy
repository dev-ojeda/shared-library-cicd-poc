#!/usr/bin/env groovy

import com.builder.util.Mock

def menu(){
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

def choiceTipo(){
    return Mock.listaTipo()
}

def choiceGeo(){
    return Mock.listaGeo()
}

def choiceDominioPorGeo(Object tipo, Object geo){
    return Mock.listaDominioPorGeo(tipo, geo)
}

return this