provider "aws" {                                  ### provider is aws, can be azure , google etc.
 region = "us-east-1"                             ### region to create aws resources.
 shared_credentials_file = "/home/ubuntu/rahul-demo/credentials"          ### Credetials to connect aws and terraform cli stored in file
 profile = "TF"                                                  ### profile name of saved aws credentials 

}

## 1st resource EC2 , will be created
resource "aws_instance" "myweb" {
  ami           = "ami-01aab85a5e4a5a0fe"                   ### AMI id for ec2
  instance_type = "t2.micro"                                ### type of ec2, large , p2 , m5 etc. 

  tags = {
    Name = "demo-web-server-terraform2"                                 ## server  name, change for demo
  }
}
## 2nd resource s3 bucket
resource "aws_s3_bucket" "b" {
  bucket = "demo-tf-09022021-terraform3"                                  ##bucket name , change for demo                       
  acl    = "private"

  tags = {
    Name        = "My bucket"                      ### Tags
    Environment = "Dev"                            ### Name of envoirnment, dev prof etc
  }
}
