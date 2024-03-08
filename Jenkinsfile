pipeline {
    agent any

    parameters {
        choice(
            choices: ['android', 'iOS'],
            description: 'Selection to OS',
            name: 'OS_TYPE_PARAM'
        )
        choice(
            choices: ['STREAMING', 'BANKING', 'DELIVERY', 'ECOMMERCE', 'SOCIAL', 'VIDEOGAME', 'DEMO_SUCCESS', 'DEMO_UNSUCCESS'],
            description: 'Selection to OS',
            name: 'APP_TYPE_PARAM'
        )
        choice(
            choices: ['manual', 'automated'],
            description: 'Selection to make tests',
            name: 'TEST_TYPE_PARAM'
        )
        choice (
            choices: ['2', '5', '8', '10', '15', '20'],
            description: 'Time on minutes of manual tests',
            name: 'TEST_TIME_PARAM'
        )
        string (
            defaultValue: 'false',
            description: '',
            name: 'STRICT_MODE_PARAM'
        )
        string (
            defaultValue: 'com.example.descuentosapp',
            description: 'package app to test',
            name: 'PACKAGE_ID_PARAM'
        )
    }

    stages {

        stage ('Build') {
            steps {
                sh '''
                set
                echo "********************************************************"
                echo "*                                                      *"
                echo "*   🚀 Iniciando el proceso de construcción 🚀          *"
                echo "*                                                      *"
                echo "********************************************************"
                ./gradlew build
                '''
            }
        }

        stage('Test'){
            steps{
                /*
                sh '''
                echo "Pruebas Unitarias"
                ./gradlew :app:assembleDebugAndroidTest
                '''
                */

                sh '''
                echo "Pruebas Unitarias"
                ./gradlew test
                '''
            }
        }

        stage ('Test UI') {
            steps {
                sh '''
                    set
                    echo "********************************************************"
                    echo "*                                                      *"
                    echo "*          🧪 Iniciando las pruebas UI🧪                  *"
                    echo "*                                                      *"
                    echo "********************************************************"
                    '''
                    script {
                        compileAndroid = sh (script: 'bash scripts/tests.sh ${PACKAGE_ID_PARAM} ${OS_TYPE_PARAM} ${TEST_TYPE_PARAM} ${TEST_TIME_PARAM} ${STRICT_MODE_PARAM} ${APP_TYPE_PARAM}')
                }
            }
        }

        stage('Analize battery stats') {
            steps {
                sh '''
                set
                echo "**********************************************************"
                echo "*                                                        *"
                echo "*   🔋 Iniciando el análisis del consumo de batería 🔋    *"
                echo "*                                                        *"
                echo "**********************************************************"
                sleep 10
                '''

                script {
                    buildFile = sh (script: 'python3 ${WORKSPACE}/scripts/readit.py ${WORKSPACE} ${OS_TYPE_PARAM} ${TEST_TYPE_PARAM} ${TEST_TIME_PARAM} ${STRICT_MODE_PARAM} ${APP_TYPE_PARAM} ${PACKAGE_ID_PARAM}')
                }
            }
        }
    }

    post{
        always{
            archiveArtifacts artifacts: 'app/build/outputs/apk/debug/app-debug.apk', onlyIfSuccessful: true
        }
    }
}