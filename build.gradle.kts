plugins {
    groovy
    id("com.gradle.build-scan") version "1.15.2"
    id("org.gradle.guides.getting-started") version "0.14.0"
    id("org.gradle.guides.test-jvm-code") version "0.14.0"
}

configure<org.gradle.guides.GuidesExtension> {
    repoPath = "gradle-guides/building-java-applications"
    mainAuthor = "Ken Kousen"
}

dependencies {
    testCompile(localGroovy())
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_7
    targetCompatibility = JavaVersion.VERSION_1_7
}

buildScan {
    setTermsOfServiceUrl("https://gradle.com/terms-of-service")
    setTermsOfServiceAgree("yes")
    if (!System.getenv("CI").isNullOrEmpty()) {
        publishAlways()
        tag("CI")
    }
}
