<!-- ABOUT THE PROJECT -->
## About The Project

A simple automation project to test [Todo Lists](https://todo-list-login.firebaseapp.com/).
Points to verify:
1. Login using your GitHub account.
2. Create 10 to do list with random strings.
3. Upon completion log out.
4. Login again with the same account.
5. Delete your list from 5 - 10.
6. Logout upon completion.

## Prerequisites

To execute the project, you will need to set up the environment for Java and related tools:
</br>1. Programming language: [Java](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html)
</br>2. Assertion framework: [TestNG](https://testng.org/doc/)
</br>3. Build tool: [Maven](http://maven.apache.org/)
</br>4. IDE: [Eclipse](https://www.eclipse.org/)

To simplify the setting step, you can install the Java environment [1], then download [the portable IDE](https://drive.google.com/file/d/1H881L37n-bnhxWESgwGJKtCtNp2QMt35/view?usp=sharing), extract and open to use. (hope this way would work)

## Usage

0. You can watch [this instruction video](https://drive.google.com/file/d/1MhWQIJPn4N_cHxdGLWwUgPS-nL-9q_ZI/view?usp=sharing) instead of reading the following steps.
1. Get the source code at [websparks-master](https://github.com/nguyenluong512/websparks-master)
2. Extract the source
3. In Eclipse, select File > Import... > Maven > Existing Maven Projects > click Next.
4. In Root Directory, point to the folder contains the source, then in Projects board below you would see /pom.xml of automation project. Select it and click Finish to complete the import process.
5. To import the execution configuration, select File > Import... > Run/Debug > Launch Configurations > click Next.
6. In From Directory, point to the folder contains the execution configuration named 'websparks-eclipse-config', select this launch file in the below window and click Finish to complete the import process. After this step, in Run Configurations window, you would see 'websparks-eclipse-config' under Maven Build category.
7. To execute the test, open ./suites/websparks.xml, right-click and select Run As > Run Configurations. In Run Configurations window, select Maven Build > websparks-eclipse-config and click Run.

<!-- CONTACT -->
## Contact

[Nguyen Luong](https://www.linkedin.com/in/nguyen-luong-8b5286176/) - nguyenluongit12@gmail.com
</br>Project Link: [websparks-master](https://github.com/nguyenluong512/websparks-master)
