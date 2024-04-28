#!/usr/bin/env groovy

import com.builder.template.Menu

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
                        script: Menu.choice_tipo()
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
                        script: Menu.choice_geo()
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
                        script: Menu.choice_dominio_por_geo(this.params.Tipo,this.params.Geos)
                    ]
                ]
            ]
        ])
    ])
}