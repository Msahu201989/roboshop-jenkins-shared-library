//
//def call () {
//    pipeline {
//
//        agent {
//            node { label 'Workstation' }
//        }
//
//        stages {
//
//            stage ('code quality') {
//                steps {
//                    echo 'code quality'
//                }
//            }
//
//            stage ('Style checks') {
//                when {
//                    branch 'demo'
//                }
//                steps {
//                    echo 'style checks'
//                }
//            }
//
//            stage ('unit Tests') {
//                when {
//                    branch 'demo'
//                }
//                steps {
//                    echo 'Unit Test'
//                }
//            }
//
//            stage ('Download dependencies') {
//                when { tag "*" }
//                steps {
//                    echo 'Download Dependencies'
//                }
//            }
//
//            stage ('Prepare Artifact') {
//                when { tag "*" }
//                steps {
//                    echo 'Prepare Artifact'
//                }
//            }
//
//            stage ('Publish Artifact') {
//                when { tag "*" }
//                steps {
//                    echo 'Publish Artifact'
//                }
//            }
//        }
//    }
//}
////
////
////
////
////
////
////
////
////
////
// @Library('roboshop') _
//
// env.COMPONENT="cart"
// nodejs()
//



def call() {
    env.APPTYPE = "nodejs"
    node {
        try {
            common.codeCheckout()
            common.codeQuality()
            common.codeChecks()
            common.artifacts()
    }  catch (Exception e) {
        mail bcc: '', body: "Build Failure ${RUN_TESTS_DISPLAY_URL}", cc: '', from: 'mukeshsahu20@gmail.com', replyTo: '', subject: 'BUILD FAILURE', to: 'mukeshsahu20@gmail.com' }

    }

}

//






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
