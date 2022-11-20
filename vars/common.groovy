def codeCheckout() {
 stage('code checkout') {
   sh 'find . | sed 1d |xargs rm -rf'
   git branch: 'main', url: "https://github.com/Msahu201989/${COMPONENT}.git"
 }
}


def codeQuality() {
    stage('Code Quality') {
        withCredentials([usernamePassword(credentialsId: 'SONAR', passwordVariable: 'sonarPass', usernameVariable: 'sonarUser')]) {
            sh '''
           #sonar-scanner -Dsonar.host.url=http://172.31.14.33:9000 -Dsonar.login=${sonarUser} -Dsonar.password=${sonarPass} -Dsonar.projectKey=${COMPONENT} -Dsonar.qualitygate.wait=true ${SONAR_EXTRA_OPTS}
           echo ok
       '''
        }
    }
 }

def codeChecks() {
    if ( env.BRANCH_NAME == "main" || TAG_NAME ==~ ".*" ) {

        stage('Style & Lint Checks') {
            echo 'Style Checks'
        }

        stage('Unit Tests') {
            echo 'unit Tests'
        }
    }
}

def artifacts() {
    if ( env.TAG_NAME ==~ ".*" ) {

       stage('Prepare  Artifacts') {
         if (env.APPTYPE == "nodejs") {
           sh ***
             npm install
             zip -r ${COMPONENT}-${TAG_NAME}.zip node_modules server.js
             ***
         }
         if (env.APPTYPE == "java") {
             sh ***
               mvn clean package
               mv target/${COMPONENT}-1.0.jar ${COMPONENT}.jar
               zip -r ${COMPONENT}-${TAG_NAME}.zip ${COMPONENT}.jar
             ***

         }
         if (env.APPTYPE == "python") {
             sh ***
               zip -r ${COMPONENT}-${TAG_NAME}.zip *.py ${COMPONENT}.ini requirements.txt
                ***

           }

         if (env.APPTYPE == "nginx") {
             sh ***
             cd static
              zip -r  ../${COMPONENT}-${TAG_NAME}.zip *
         }
       }

        stage('Publish Artifacts') {
         echo 'Publish Artifacts'
        }
        }
    }

