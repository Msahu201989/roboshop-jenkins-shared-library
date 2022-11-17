def codeQuality() {
    stage('code Quality') {
       echo 'code Quality'
            sh 'env'
        }
    }

def codeChecks() {
    if (BRANCH_NAME == "main" || tag ==~ ".*") {
        stage('Style Checks') {
            echo 'Style Checks'
        }

        stage('Unit Tests') {
            echo 'unit Tests'
        }
    }
}

def artifacts() {
    if (TAG_NAME == ~ ".*") {

        stage('Download Dependencies') {
            echo 'Download Dependencies'
        }
        
    }
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
//                    echo 'Publishh Artifact'
//                }

//            }
}