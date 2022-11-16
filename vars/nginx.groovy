def call(){
    pipeline {

        agent any

        stages {

            stage('code Quality') {
                steps{
                    echo 'code Quality'
                    sh 'env'
                }
            }

            stage('Style Checks') {
                when {
                    anyOf {
                        branch 'main'
                        tag "*"
                    }
                }
                steps{
                    echo 'code Quality'
                }
            }

            stage('Unit Tests'){
                when {
                    anyOf {
                        branch 'main'
                        tag "*"
                    }
                }
                steps{
                    echo 'code Quality'
                }
            }


            stage('Prepare Artifact') {
                when { tag "*" }
                steps {
                    echo 'Prepare Artifact'
                }
            }

            stage('Publish Artifact') {
                when { tag "*" }
                steps {
                    echo 'Publish Artifact'
                }
            }
        }
    }

}