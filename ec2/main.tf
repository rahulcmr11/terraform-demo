provider "aws" {
 region = "us-east-1"
 access_key = "AKIAXQ4SBAZ4ZBUQZWRU"
 secret_key = "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"
}

resource "aws_instance" "myweb" {
  ami           = "ami-047a51fa27710816e"
  instance_type = "t2.micro"

  tags = {
    Name = "AkuDev"
  }
}

resource "aws_s3_bucket" "b" {
  bucket = "demo-tf-08022021"
  acl    = "private"

  tags = {
    Name        = "My bucket"
    Environment = "Dev"
  }
}