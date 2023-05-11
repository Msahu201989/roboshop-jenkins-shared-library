def call() {
    node {
        try {
            common.codeQuality1()
            common.codeChecks()
            common.artifacts()
    }  catch (Exception e) {
        mail bcc: '', body: "Build Failure ${RUN_TESTS_DISPLAY_URL}", cc: '', from: 'mukeshsahu20@gmail.com', replyTo: '', subject: 'BUILD FAILURE', to: 'mukeshsahu20@gmail.com'        }

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
