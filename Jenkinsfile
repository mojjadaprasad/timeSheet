pipeline{

	agent any
	stages{
	stage('Build'){
	steps{
	echo "Building the code....."
	bat "mvn clean"
	}
	}

		stage('Test'){
	steps{
	echo "Testinging the code....."
	bat "mvn test"
	}
	}
		stage('Compile'){
	steps{
	echo "Compileing the code....."
	bat "mvn compile"
	}
	}
		stage('Deploy'){
	steps{
	echo "Building the code....."
	}
	}
	}

	}
