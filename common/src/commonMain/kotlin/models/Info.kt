package dev.inmo.resume.common.models

import kotlinx.serialization.Serializable

@Serializable
data class Info(
    val me: Me = Me(
        name = "Ovsiannikov Aleksei",
        birthday = "04.09.1995 (MM.dd.yyyy)",
        phoneText = "8-950-796-96-58",
        phoneNumber = "89507969658",
        email = "ovsyannikov.alexey95@gmail.com",
    ),
    val experience: List<Experience> = listOf(
        Experience(
            position = "Lead Software Engineer",
            company = "Smart Distribution Network",
            companyLink = "https://www.smart-dn.ru",
            period = "September 2021 – currently working",
            location = "Remote",
            additional = emptyList()
        ),
        Experience(
            position = "Middle+ Android developer",
            company = "Tinkoff",
            companyLink = "https://www.tinkoff.ru",
            period = "May 2021 – August 2021",
            location = "Remote",
            additional = emptyList()
        ),
        Experience(
            position = "Senior Software Engineer",
            company = "Smart Distribution Network",
            companyLink = "https://www.smart-dn.ru",
            period = "October 2018 – May 2021",
            location = "Remote",
            additional = emptyList()
        ),
        Experience(
            position = "Mentor (GSoC 2020 internship)",
            company = "XWiki Project",
            companyLink = "https://www.xwiki.org/",
            period = "March 2020 – September 2020",
            location = "Remote (China, Wuhan City), Remote (Russia, Omsk)",
            additional = emptyList()
        ),
        Experience(
            position = "Mentor (GSoC 2019 internship)",
            company = "XWiki Project",
            companyLink = "https://www.xwiki.org/",
            period = "March 2019 – September 2019",
            location = "Remote (China, Wuhan City), Remote (Russia, Omsk)",
            additional = emptyList()
        ),
        Experience(
            position = "Mentor (GSoC 2018 internship)",
            company = "XWiki Project",
            companyLink = "https://www.xwiki.org/",
            period = "March 2018 – September 2018",
            location = "Remote (China, Wuhan City)",
            additional = emptyList()
        ),
        Experience(
            position = "Android developer (GSoC 2018 internship)",
            company = "XWiki Project",
            companyLink = "https://www.xwiki.org/",
            period = "May 2018 - August 2018",
            location = "Remote (China, Wuhan City)",
            additional = emptyList()
        ),
        Experience(
            position = "Android developer",
            company = "Andy OS, Inc.",
            companyLink = "https://www.linkedin.com/company/8179828/",
            period = "December 2016 - March 2018",
            location = "Russia, Omsk city",
            additional = emptyList()
        ),
        Experience(
            position = "Junior engineer",
            company = "LLC Hello World! Technologies (HWdTech LLC)",
            companyLink = "https://www.linkedin.com/company/17952851/",
            period = "March 2016 - August 2016",
            location = "Russia, Omsk city",
            additional = emptyList()
        ),
        Experience(
            position = "Intern",
            company = "LLC Hello World! Technologies (HWdTech LLC)",
            companyLink = "https://www.linkedin.com/company/17952851/",
            period = "December 2015 - March 2016",
            location = "Russia, Omsk city",
            additional = emptyList()
        ),
        Experience(
            position = "Intern",
            company = "7bits",
            companyLink = "https://www.linkedin.com/company/2559736/",
            period = "July 2015 - September 2015",
            location = "Russia, Omsk city",
            additional = emptyList()
        )
    ),
    val education: List<Education> = listOf(
        Education(
            grade = "Master",
            university = "Wuhan University (China)",
            major = "Software Engineering",
            yearOfGraduation = "2019",
            additional = listOf(
                "Registration number of Graduation Certificate" to "104869201902000047",
                "Registration number of Degree Certificate" to "1048632019203277"
            )
        ),
        Education(
            grade = "Bachelor",
            university = "Omsk State University (Russia)",
            major = "Informatics and computer science",
            yearOfGraduation = "2017",
            additional = listOf(
                "Document registration number" to "7117.0096"
            )
        )
    ),
    val projects: List<Project> = listOf(
        Project(
            title = "tgbotapi",
            link = "https://github.com/InsanusMokrassar/TelegramBotAPI",
            description = "Wrapper library for Telegram Bots API written in kotlin multiplatform"
        )
    ),
    val github: Github? = Github(
        "InsanusMokrassar"
    )
)
