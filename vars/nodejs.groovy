def call() {
    node {

        if (!env.TAG_NAME) {
            sh 'env'
         common.codeQuality()
    if( BRANCH_NAME == "main" || tag ==~ ".*" ) {
            stage('Style checks') {
              echo 'code Quality'
                }
            }
        }

//            stage('unit Tests') {
//                steps {
//                    echo 'Unit Test'
//                }
//            }
//
//            stage('Download dependencies') {
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
//                when { tag "1.0.0" }
//                steps {
//                    echo 'Publish Artifact'
//                }
//            }
//        }
   }
}









// @Library('roboshop') _
//
// env.COMPONENT="cart"
// nodejs()







//def call() {
//  env.APPTYPE = "nodejs"
//  node {
//    try {
//        common.codeCheckout()
//        common.codeQuality()
//        common.codeChecks()
//        common.artifacts()
//    }  catch (Exception e) {
//        mail bcc: '', body: "Build Failure ${RUN_TESTS_DISPLAY_URL}", cc: '', from: 'mukeshsahu20@gmail.com', replyTo: '', subject: 'BUILD FAILURE', to: 'mukeshsahu20@gmail.com'
//    }
//
//  }
//
//}
//
