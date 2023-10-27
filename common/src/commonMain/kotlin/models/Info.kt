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
    val experience: List<Experience>? = listOf(
        Experience(
            position = "Lead Software Engineer",
            company = "Smart Distribution Network",
            period = "09.2021 – currently working",
            location = "Remote",
            additional = emptyList(),
            companyLink = "https://www.smart-dn.ru",
            companyImgLink = "img/company_sdn.svg"
        ),
        Experience(
            position = "Middle+ Android developer",
            company = "Tinkoff",
            companyLink = "https://www.tinkoff.ru",
            period = "05.2021 – 08.2021",
            location = "Remote",
            additional = emptyList(),
            companyImgLink = "img/company_tinkoff.svg"
        ),
        Experience(
            position = "Senior Software Engineer",
            company = "Smart Distribution Network",
            companyLink = "https://www.smart-dn.ru",
            period = "11.2018 – 05.2021",
            location = "Remote",
            additional = emptyList(),
            companyImgLink = "img/company_sdn.svg"
        ),
        Experience(
            position = "Mentor (GSoC 2020 internship)",
            company = "XWiki Project",
            companyLink = "https://www.xwiki.org/",
            period = "03.2020 – 09.2020",
            location = "Remote (China, Wuhan City), Remote (Russia, Omsk)",
            additional = emptyList(),
            companyImgLink = "img/company_xwiki.svg"
        ),
        Experience(
            position = "Mentor (GSoC 2019 internship)",
            company = "XWiki Project",
            companyLink = "https://www.xwiki.org/",
            period = "03.2019 – 09.2019",
            location = "Remote (China, Wuhan City), Remote (Russia, Omsk)",
            additional = emptyList(),
            companyImgLink = "img/company_xwiki.svg"
        ),
        Experience(
            position = "Android developer (GSoC 2018 internship)",
            company = "XWiki Project",
            companyLink = "https://www.xwiki.org/",
            period = "05.2018 - 08.2018",
            location = "Remote (China, Wuhan City)",
            additional = emptyList(),
            companyImgLink = "img/company_xwiki.svg"
        ),
        Experience(
            position = "Android developer",
            company = "Andy OS, Inc.",
            companyLink = "https://www.linkedin.com/company/8179828/",
            period = "12.2016 - 03.2018",
            location = "Russia, Omsk city",
            additional = emptyList(),
            companyImgLink = "img/company_andy.webp"
        ),
        Experience(
            position = "Junior engineer",
            company = "LLC Hello World! Technologies (HWdTech LLC)",
            companyLink = "https://www.linkedin.com/company/17952851/",
            period = "03.2016 - 08.2016",
            location = "Russia, Omsk city",
            additional = emptyList(),
            companyImgLink = "img/company_hwdtech.svg"
        ),
        Experience(
            position = "Intern",
            company = "LLC Hello World! Technologies (HWdTech LLC)",
            companyLink = "https://www.linkedin.com/company/17952851/",
            period = "12.2015 - 03.2016",
            location = "Russia, Omsk city",
            additional = emptyList(),
            companyImgLink = "img/company_hwdtech.svg"
        ),
        Experience(
            position = "Intern",
            company = "7bits",
            companyLink = "https://www.linkedin.com/company/2559736/",
            period = "07.2015 - 09.2015",
            location = "Russia, Omsk city",
            additional = emptyList(),
            companyImgLink = "img/company_7bits.svg"
        )
    ),
    val education: List<Education>? = listOf(
        Education(
            grade = "Bachelor",
            university = "Omsk State University (Russia)",
            major = "Informatics and computer science",
            yearOfGraduation = "2017",
            additional = listOf(
                "Document registration number" to "7117.0096"
            )
        ),
        Education(
            grade = "Master",
            university = "Wuhan University (China)",
            major = "Software Engineering",
            yearOfGraduation = "2019",
            additional = listOf(
                "Registration number of Graduation Certificate" to "104869201902000047",
                "Registration number of Degree Certificate" to "1048632019203277"
            )
        )
    ),
    val projects: List<Project>? = listOf(
        Project(
            title = "tgbotapi",
            link = "https://github.com/InsanusMokrassar/TelegramBotAPI",
            description = "Wrapper library for Telegram Bots API written in kotlin multiplatform"
        )
    ),
    val github: Github? = Github(
        "InsanusMokrassar",
        sortBy = Github.SortBy.STARS,
        sort = Github.SortOrder.DESC,
        count = 20
    ),
    val useAllInOnePage: Boolean = true
)
