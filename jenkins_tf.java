import groovy.json.JsonSlurper
@Library('github.com/releaseworks/jenkinslib') _ 
String CODE_REPO = "https://github.com/rahulcmr11/terraform-demo.git"
node {

    ws("terraform-demo-demo") {

        stage('checkout-git') {

           checkout changelog: false, poll: false, scm: [$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'demo-terraform', url: CODE_REPO]]]

        }
	    
	    stage('check_init_plan') {
		
		sh '''
			sudo cd ec2
			sudo terraform init 
			sudo terraform plan
			
			 
		'''    
		println("All look good . Please run the apply deploy")	
        }
	    
	    stage('apply_the_plan') {
		    
	sh '''
			whoami
			 
		'''
			
        }
	    
        }
        }

