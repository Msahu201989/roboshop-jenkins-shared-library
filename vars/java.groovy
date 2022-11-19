def call() {
    env.SONAR_EXTRA_OPTS = "-Dsonar.java.binaries=./target"
    node {
        try {
            common.codeCheckout()
            stage('compile code'){
                sh 'mvn compile'
            }
            common.codeQuality()
            common.codeChecks()
            common.artifacts()
        }  catch (Exception e) {
            mail bcc: '', body: "Build Failure ${RUN_TESTS_DISPLAY_URL}", cc: '', from: 'mukeshsahu20@gmail.com', replyTo: '', subject: 'BUILD FAILURE', to: 'mukeshsahu20@gmail.com'
        }

    }

}

