import groovy.json.JsonSlurper
@Library('github.com/releaseworks/jenkinslib') _ 
String CODE_REPO = "https://github.com/rahulcmr11/terraform-demo.git" // clone this git repo
node {

    ws("terraform-demo-demo") {    // workspace for server

        stage('checkout-git') {

           checkout changelog: false, poll: false, scm: [$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'demo-terraform', url: CODE_REPO]]]

        }
	    
	    stage('check_init') {  // run terraform init 
		
		sh '''
			cd ec2-s3
			sudo terraform init 
			
			
			 
		'''    
		println("All look good . Please run the terraform apply ")	
        }
	    
	    stage('destroy_the_resources') {   // after success of above stage run the apply
		    
	sh '''
	    cd ec2-s3
	    sudo terraform destroy -auto-approve # destroy resources  
			 
	  '''
			
        }
	
	  
	    
        }
        }
