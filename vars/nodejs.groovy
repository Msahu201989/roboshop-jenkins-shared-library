def call() {
    node {

        sh 'env'
        common.codeQuality()

        if (BRANCH_NAME == "main" || tag ==~ "*") {
            stage('Style Checks') {
                echo 'Style Checks'
                }
            }
       }
//
//
//            stage('Unit Tests'){
//                when {
//                    anyOf {
//                        branch 'main'
//                        tag "*"
//                    }
//                }
//                steps{
//                    echo 'code Quality'
//                }
//            }
//
//            stage('Download Dependencies') {
//                when { tag "*" }
//                steps {
//                    echo 'Download Dependencies'
//                }
//            }
//
//            stage('Prepare Artifact') {
//                when { tag "*" }
//                steps {
//                    echo 'Prepare Artifact'
//                }
//            }
//
//            stage('Publish Artifact') {
//                when { tag "*" }
//                steps {
//                    echo 'Publish Artifact'
//                }
//            }

        }

}