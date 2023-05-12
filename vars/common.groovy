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
        sonar-scanner -Dsonar.host.url=http://172.31.7.47:9000 -Dsonar.login=${sonarUser} -Dsonar.password=${sonarPass} -Dsonar.projectKey=${COMPONENT} -Dsonar.qualitygate.wait=true ${SONAR_EXTRA_OPTS}
      '''
        }
    }
}

def codeChecks() {
    if ( env.BRANCH_NAME == "main" || env.TAG_NAME ==~ ".*" ) {

        stage('Style Checks') {
            echo 'Style Checks'
        }

        stage('Unit Tests') {
            echo 'Unit Tests'
        }

    }
}

def artifacts() {
    if ( env.TAG_NAME ==~ ".*" ) {

        stage('Download Dependencies') {
            echo 'Download Dependencies'
        }

        stage('Prepare Artifacts') {
            echo 'Prepare Artifacts'
        }

        stage('Publish Artifacts') {
            echo 'Publish Artifacts'
        }

    }
}

//
//
//def codeCheckout() {
// stage('code checkout') {
//   sh 'find . | sed 1d |xargs rm -rf'
//   git branch: 'main', url: "https://github.com/Msahu201989/${COMPONENT}.git"
// }
//}
//
//
//def codeQuality() {
//    stage('Code Quality') {
//        withCredentials([usernamePassword(credentialsId: 'SONAR', passwordVariable: 'sonarPass', usernameVariable: 'sonarUser')]) {
//            sh '''
//           #sonar-scanner -Dsonar.host.url=http://172.31.14.33:9000 -Dsonar.login=${sonarUser} -Dsonar.password=${sonarPass} -Dsonar.projectKey=${COMPONENT} -Dsonar.qualitygate.wait=true ${SONAR_EXTRA_OPTS}
//           echo ok
//       '''
//        }
//    }
// }
//
//def codeChecks() {
//    if ( env.BRANCH_NAME == "main" || TAG_NAME ==~ ".*" ) {
//
//        stage('Style & Lint Checks') {
//            echo 'Style Checks'
//        }
//
//        stage('Unit Tests') {
//            echo 'unit Tests'
//        }
//    }
//}
//
//def artifacts() {
//
//        stage('Prepare  Artifacts') {
//            if (env.APPTYPE == "nodejs") {
//                sh '''
//             npm install
//             #zip -r ${COMPONENT}-${TAG_NAME}.zip node_modules server.js
//             '''
//            }
//            if (env.APPTYPE == "java") {
//                sh '''
//               mvn clean package
//               mv target/${COMPONENT}-1.0.jar ${COMPONENT}.jar
//               #zip -r ${COMPONENT}-${TAG_NAME}.zip ${COMPONENT}.jar
//             '''
//
//            }
//            if (env.APPTYPE == "python") {
//                sh '''
//               #zip -r ${COMPONENT}-${TAG_NAME}.zip *.py ${COMPONENT}.ini requirements.txt
//                '''
//
//            }
//
//            if (env.APPTYPE == "nginx") {
//                sh '''
//             #cd static
//              #zip -r  ../${COMPONENT}-${TAG_NAME}.zip *
//              '''
//            }
//        }
////            stage('Build Docker Image') {
////                sh '''
////               docker build -t 332775960109.dkr.ecr.us-east-1.amazonaws.com/${COMPONENT}:latest .
////             '''
////            }

//    if ( env.TAG_NAME ==~ ".*" ) {
//
////    stage('Publish Docker Image') {
////        sh '''
////     aws ecr get-login-password --region us-east-1 | docker login --username AWS --password-stdin 332775960109.dkr.ecr.us-east-1.amazonaws.com
////     docker tag 332775960109.dkr.ecr.us-east-1.amazonaws.com/${COMPONENT}:latest 332775960109.dkr.ecr.us-east-1.amazonaws.com/${COMPONENT}:${TAG_NAME}
////     docker push 332775960109.dkr.ecr.us-east-1.amazonaws.com/${COMPONENT}:${TAG_NAME}
////             '''
////    }
//
//
//       stage('Publish Artifacts') {
//            withCredentials([usernamePassword(credentialsId: 'NEXUS', passwordVariable: 'nexusPass', usernameVariable: 'nexusUser')]) {
//             sh '''
//         curl -v -u ${nexusUser}:${nexusPass} --upload-file ${COMPONENT}-${TAG_NAME}.zip http://nexus.roboshop.internal:8081/repository/${COMPONENT}/${COMPONENT}-${TAG_NAME}.zip
//            '''
//          }
//       }
//   }
//    }
//
//
//
