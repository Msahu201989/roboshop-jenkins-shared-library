def call() {
    pipeline {

        agent any

        stages {

            common.codeQuality()

            stage('Style checks') {
                steps {
                    echo 'style checks'
                }
            }

            stage('unit Tests') {
                steps {
                    echo 'Unit Test'
                }
            }

            stage('Download dependencies') {
                when { tag "*" }
                steps {
                    echo 'Download Dependencies'
                }
            }

            stage('Prepare Artifact') {
                when { tag "*" }
                steps {
                    echo 'Prepare Artifact'
                }
            }

            stage('Publish Artifact') {
                when { tag "1.0.0" }
                steps {
                    echo 'Publish Artifact'
                }
            }
        }
    }
}



//def call() {
//    env.APPTYPE = "nginx"
//    node {
//        try {
//            common.codeCheckout()
//            common.codeQuality()
//            common.codeChecks()
//            common.artifacts()
//        }  catch (Exception e) {
//            mail bcc: '', body: "Build Failure ${RUN_TESTS_DISPLAY_URL}", cc: '', from: 'mukeshsahu20@gmail.com', replyTo: '', subject: 'BUILD FAILURE', to: 'mukeshsahu20@gmail.com'
//        }
//
//    }
//
//}
//
