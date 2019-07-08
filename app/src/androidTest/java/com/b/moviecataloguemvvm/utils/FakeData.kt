package com.b.moviecataloguemvvm.utils

import com.b.moviecataloguemvvm.R
import com.b.moviecataloguemvvm.model.FeaturedCrew
import com.b.moviecataloguemvvm.model.MovieModel
import com.b.moviecataloguemvvm.model.TvShowModel

object FakeData {
    fun generateMovies(): List<MovieModel> {
        val movies: ArrayList<MovieModel> = ArrayList()
        movies.add(
            MovieModel(
                1,
                "A Star Is Born",
                "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
                R.drawable.movie_a_start_is_born,
                "October 3, 2018",
                "75",
                "https://youtu.be/nSbzyEJ8X9E",
                listOf(
                    FeaturedCrew(
                        "Bradley Cooper",
                        "Director, Screenplay"
                    ),
                    FeaturedCrew(
                        "Will Fetters",
                        "Screenplay"
                    ),
                    FeaturedCrew(
                        "Eric Roth",
                        "Screenplay"
                    ),
                    FeaturedCrew(
                        "Robert Carson",
                        "Story"
                    ),
                    FeaturedCrew(
                        "William A. Wellman",
                        "Story"
                    )
                )
            )
        )


        movies.add(
            MovieModel(
                2,
                "Alita: Battle Angel",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                R.drawable.movie_alita,
                "January 31, 2019",
                "67",
                "https://youtu.be/aj8mN_7Apcw",
                listOf(
                    FeaturedCrew(
                        "Robert Rodriguez",
                        "Director"

                    ), FeaturedCrew(
                        "Laeta Kalogridis",
                        "Screenplay"
                    ),
                    FeaturedCrew(
                        "James Cameron",
                        "Screenplay"
                    )
                )
            )
        )

        movies.add(
            MovieModel(
                3,
                "Aquaman",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                R.drawable.movie_aquaman,
                "December 7, 2018",
                "68",
                "https://youtu.be/WDkg3h8PCVU",
                listOf(
                    FeaturedCrew(
                        "James Wan",
                        "Director,Story"
                    ),
                    FeaturedCrew(
                        "Will Beall"
                        , "Screenplay, Story"
                    ),
                    FeaturedCrew(
                        "Paul Norris",
                        "Characters"
                    ),
                    FeaturedCrew(
                        "Mort Weisinger",
                        "Characters"
                    ),
                    FeaturedCrew(
                        "David Leslie Johnson-McGoldrick",
                        "Screenplay"
                    ),
                    FeaturedCrew(
                        "Geoff Johns",
                        "Story"
                    )
                )
            )
        )

        movies.add(
            MovieModel(
                4,
                "Bohemian Rhapsody",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                R.drawable.movie_bohemian,
                "October 24, 2018",
                "81",
                "https://youtu.be/HlRd9Zy25zo",
                listOf(
                    FeaturedCrew(
                        "Anthony McCarten",
                        "Screenplay, Story"
                    ),
                    FeaturedCrew(
                        "Bryan Singer",
                        "Director"
                    ),
                    FeaturedCrew(
                        "Dexter Fletcher",
                        "Director"
                    ),
                    FeaturedCrew(
                        "Peter Morgan",
                        "Story"
                    )
                )
            )
        )

        movies.add(
            MovieModel(
                5,
                "Cold Pursuit",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                R.drawable.movie_cold_persuit,
                "February 7, 2019",
                "54",
                "https://youtu.be/0phuNQQ_gHI",
                listOf(
                    FeaturedCrew(
                        "Hans Petter Moland"
                        , "Director"

                    ),
                    FeaturedCrew(
                        "Frank Baldwin",
                        "Screenplay"
                    )
                )
            )
        )

        movies.add(
            MovieModel(
                6,
                "Creed",
                "The former World Heavyweight Champion Rocky Balboa serves as a trainer and mentor to Adonis Johnson, the son of his late friend and former rival Apollo Creed.",
                R.drawable.movie_creed,
                "November 25, 2015",
                "73",
                "https://youtu.be/Uv554B7YHk4",
                listOf(
                    FeaturedCrew(
                        "Ryan Coogler",
                        "Director, Screenplay, Story"
                    ),
                    FeaturedCrew(
                        "Sylvester Stallone",
                        "Characters"
                    ),
                    FeaturedCrew(
                        "Aaron Covington",
                        "Screenplay"
                    )
                )
            )
        )

        movies.add(
            MovieModel(
                7,
                "Fantastic Beasts: The Crimes of Grindelwald",
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
                R.drawable.movie_crimes,
                "November 14, 2018",
                "69",
                "https://youtu.be/5sEaYB4rLFQ",
                listOf(
                    FeaturedCrew(
                        "David Yates",
                        "Director"
                    ),
                    FeaturedCrew(
                        "J.K. Rowling",
                        "Screenplay"
                    )
                )
            )
        )

        movies.add(
            MovieModel(
                8,
                "Glass",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                R.drawable.movie_glass,
                "January 16, 2019",
                "65",
                "https://youtu.be/95ghQs5AmNk",
                listOf(
                    FeaturedCrew(
                        "M. Night Shyamalan",
                        "Director, Screenplay"
                    )
                )
            )
        )

        movies.add(
            MovieModel(
                9,
                "How to Train Your Dragon: The Hidden World",
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                R.drawable.movie_how_to_train,
                "January 3, 2019",
                "76",
                "https://youtu.be/qNGLuCijKZ0",
                listOf(
                    FeaturedCrew(
                        "Dean DeBlois",
                        "Director, Screenplay, Story"
                    ),
                    FeaturedCrew(
                        "Cressida Cowell",
                        "Novel"
                    )
                )
            )
        )

        movies.add(
            MovieModel(
                10,
                "Avengers: Infinity War",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                R.drawable.movie_infinity_war,
                "April 25, 2018",
                "83",
                "https://youtu.be/sAOzrChqmd0",
                listOf(
                    FeaturedCrew(
                        "Joe Russo",
                        "Director"
                    ),
                    FeaturedCrew(
                        "Anthony Russo",
                        "Director"
                    ),
                    FeaturedCrew(
                        "Stephen McFeely",
                        "Screenplay"
                    ),
                    FeaturedCrew(
                        "Christopher Markus",
                        "Screenplay"
                    )
                )
            )
        )

        movies.add(
            MovieModel(
                11,
                "Mary Queen of Scots",
                "In 1561, Mary Stuart, widow of the King of France, returns to Scotland, reclaims her rightful throne and menaces the future of Queen Elizabeth I as ruler of England, because she has a legitimate claim to the English throne. Betrayals, rebellions, conspiracies and their own life choices imperil both Queens. They experience the bitter cost of power, until their tragic fate is finally fulfilled.",
                R.drawable.movie_marry_queen,
                "December 7, 2018",
                "66",
                "https://youtu.be/wnqjSgMU36U",
                listOf(
                    FeaturedCrew(
                        "Josie Rourke",
                        "Director"
                    ),
                    FeaturedCrew(
                        "Beau Willimon",
                        "Screenplay"
                    )
                )
            )
        )

        movies.add(
            MovieModel(
                12,
                "Master Z: Ip Man Legacy",
                "After being defeated by Ip Man, Cheung Tin Chi is attempting to keep a low profile. While going about his business, he gets into a fight with a foreigner by the name of Davidson, who is a big boss behind the bar district. Tin Chi fights hard with Wing Chun and earns respect.",
                R.drawable.movie_master_z,
                "December 20, 2018",
                "52",
                "https://youtu.be/of1IKuYgj-c",
                listOf(
                    FeaturedCrew(
                        "Yuen Woo-ping",
                        "Director"
                    ),
                    FeaturedCrew(
                        "Chan Tai-Li",
                        "Screenplay"
                    ),
                    FeaturedCrew(
                        "Edmond Wong",
                        "Screenplay"
                    )
                )
            )
        )

        movies.add(
            MovieModel(
                13,
                "Mortal Engines",
                "Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom Natsworthy has an unexpected encounter with a mysterious young woman from the wastelands who will change the course of his life forever.",
                R.drawable.movie_mortal_engines,
                "November 27, 2018",
                "60",
                "https://youtu.be/IRsFc2gguEg",
                listOf(
                    FeaturedCrew(
                        "Christian Rivers",
                        "Director"
                    ),
                    FeaturedCrew(
                        "Philip Reeve",
                        "Novel"
                    ),
                    FeaturedCrew(
                        "Philippa Boyens",
                        "Screenplay"
                    ),
                    FeaturedCrew(
                        "Fran Walsh",
                        "Screenplay"
                    ),
                    FeaturedCrew(
                        "Peter Jackson",
                        "Screenplay"
                    )
                )
            )
        )


        movies.add(
            MovieModel(
                14,
                "Overlord",
                "France, June 1944. On the eve of D-Day, some American paratroopers fall behind enemy lines after their aircraft crashes while on a mission to destroy a radio tower in a small village near the beaches of Normandy. After reaching their target, the surviving paratroopers realise that, in addition to fighting the Nazi troops that patrol the village, they also must fight against something else.",
                R.drawable.movie_overlord,
                "November 1, 2018",
                "66",
                "https://youtu.be/USPd0vX2sdc",
                listOf(
                    FeaturedCrew(
                        "Billy Ray",
                        "Screenplay, Story"
                    ),
                    FeaturedCrew(
                        "Julius Avery",
                        "Director"
                    ),
                    FeaturedCrew(
                        "Mark L. Smith",
                        "Screenplay"
                    )

                )
            )
        )

        movies.add(
            MovieModel(
                15,
                "Ralph Breaks the Internet",
                "Video game bad guy Ralph and fellow misfit Vanellope von Schweetz must risk it all by traveling to the World Wide Web in search of a replacement part to save Vanellope's video game, \"Sugar Rush.\" In way over their heads, Ralph and Vanellope rely on the citizens of the internet -- the netizens -- to help navigate their way, including an entrepreneur named Yesss, who is the head algorithm and the heart and soul of trend-making site BuzzzTube.\n",
                R.drawable.movie_ralph,
                "November 20, 2018",
                "72",
                "https://youtu.be/DIBw9dSVKdU",
                listOf(
                    FeaturedCrew(
                        "Phil Johnston",
                        "Director, Story, Writer"
                    ),
                    FeaturedCrew(
                        "Rich Moore",
                        "Director, Story"
                    ),
                    FeaturedCrew(
                        "Pamela Ribon",
                        "Story, Writer"
                    ),
                    FeaturedCrew(
                        "Josie Trinidad",
                        "Story"
                    ),
                    FeaturedCrew(
                        "Jim Reardon",
                        "Story"
                    )
                )
            )
        )

        movies.add(
            MovieModel(
                16,
                "Robin Hood",
                "A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English crown.",
                R.drawable.movie_robin_hood,
                "November 20, 2018",
                "58",
                "https://youtu.be/tJfDBSWYqU8",
                listOf(
                    FeaturedCrew(
                        "Ben Chandler",
                        "Screenplay, Story"
                    ),
                    FeaturedCrew(
                        "Otto Bathurst",
                        "Director"
                    ),
                    FeaturedCrew(
                        "David James Kelly",
                        "Screenplay"
                    )
                )
            )
        )

        movies.add(
            MovieModel(
                17,
                "Serenity",
                "Baker Dill is a fishing boat captain leading tours off a tranquil, tropical enclave called Plymouth Island. His quiet life is shattered, however, when his ex-wife Karen tracks him down with a desperate plea for help.",
                R.drawable.movie_serenity,
                "January 24, 2019",
                "51",
                "https://youtu.be/k3zMlsEK8xA",
                listOf(
                    FeaturedCrew(
                        "Steven Knight",
                        "Director, Screenplay"
                    )
                )
            )
        )

        movies.add(
            MovieModel(
                18,
                "Spider-Man: Into the Spider-Verse",
                "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \"Kingpin\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension.",
                R.drawable.movie_spiderman,
                "December 6, 2018",
                "84",
                "https://youtu.be/ii3n7hYQOl4",
                listOf(
                    FeaturedCrew(
                        "Rodney Rothman",
                        "Director, Screenplay"
                    ),
                    FeaturedCrew(
                        "Phil Lord",
                        "Screenplay, Story"
                    ),
                    FeaturedCrew(
                        "Steve Ditko",
                        "Characters"
                    ),
                    FeaturedCrew(
                        "Stan Lee",
                        "Characters"
                    ),
                    FeaturedCrew(
                        "Bob Persichetti",
                        "Director"
                    ),
                    FeaturedCrew(
                        "Peter Ramsey",
                        "Director"
                    )
                )
            )
        )

        movies.add(
            MovieModel(
                19,
                "T-34",
                "In 1944, a courageous group of Russian soldiers managed to escape from German captivity in a half-destroyed legendary T-34 tank. Those were the times of unforgettable bravery, fierce fighting, unbreakable love, and legendary miracles.",
                R.drawable.movie_t34,
                "December 27, 2018",
                "49",
                "https://youtu.be/Qm_5TYbxgpc",
                listOf(
                    FeaturedCrew(
                        "Aleksey Sidorov",
                        "Director, Screenplay"
                    )
                )
            )
        )
        return movies
    }

    fun generateTvShow(): List<TvShowModel> {
        val tvShows: ArrayList<TvShowModel> = ArrayList()
        tvShows.add(
            TvShowModel(
                1,
                "Arrow",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                R.drawable.tvshow_arrow,
                "October 10, 2012",
                "58",
                "https://youtu.be/hTv13EjlLNg",
                listOf(
                    FeaturedCrew(
                        "Greg Berlanti",
                        "Creator"
                    ),
                    FeaturedCrew(
                        "Marc Guggenheim",
                        "Creator"
                    ),
                    FeaturedCrew(
                        "Andrew Kreisberg",
                        "Creator"
                    )
                )
            )
        )


        tvShows.add(
            TvShowModel(
                2,
                "Doom Patrol",
                "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
                R.drawable.tvshow_doom_patrol,
                "February 15, 2019",
                "61",
                "https://youtu.be/6wtGnnLfTqA",
                listOf(
                    FeaturedCrew(
                        "Jeremy Carver",
                        "Creator"
                    )
                )
            )
        )

        tvShows.add(
            TvShowModel(
                3,
                "Dragon Ball",
                "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the dragon balls brought her to Goku's home. Together, they set off to find all seven dragon balls in an adventure that would change Goku's life forever. See how Goku met his life long friends Bulma, Yamcha, Krillin, Master Roshi and more. And see his adventures as a boy, all leading up to Dragonball Z and later Dragonball GT.\n",
                R.drawable.tvshow_dragon_ball,
                "February 26, 1986",
                "71",
                "https://youtu.be/y_0APzy4BcU",
                listOf(
                    FeaturedCrew(
                        "Akira Toriyama",
                        "Creator"
                    )
                )
            )
        )

        tvShows.add(
            TvShowModel(
                4,
                "Fairy Tail",
                "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
                R.drawable.tvshow_fairytail,
                "October 12, 2009",
                "64",
                "https://youtu.be/29jsKEZN1ag",
                listOf(
                    FeaturedCrew("", "")
                )
            )
        )

        tvShows.add(
            TvShowModel(
                5,
                "Family Guy",
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                R.drawable.tvshow_family_guy,
                "January 31, 1999",
                "65",
                "https://youtu.be/t3VtKdoPIYE",
                listOf(
                    FeaturedCrew(
                        "Seth MacFarlane",
                        "Creator"
                    )
                )
            )
        )

        tvShows.add(
            TvShowModel(
                6,
                "The Flash",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                R.drawable.tvshow_flash,
                "October 7, 2014",
                "67",
                "https://youtu.be/Yj0l7iGKh8g",
                listOf(
                    FeaturedCrew(
                        "Geoff Johns",
                        "Creator"
                    ),
                    FeaturedCrew(
                        "Andrew Kreisberg",
                        "Creator"
                    ),
                    FeaturedCrew(
                        "Greg Berlanti",
                        "Creator"
                    )
                )
            )
        )

        tvShows.add(
            TvShowModel(
                7,
                "Game of Thrones",
                "leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
                R.drawable.tvshow_god,
                "April 17, 2011",
                "81",
                "https://youtu.be/BpJYNVhGf1s",
                listOf(
                    FeaturedCrew(
                        "David Benioff",
                        "Creator"
                    ),
                    FeaturedCrew(
                        "D. B. Weiss",
                        "Creator"
                    )
                )
            )
        )

        tvShows.add(
            TvShowModel(
                8,
                "Gotham",
                "Before there was Batman, there was GOTHAM.\n" +
                        "\n" +
                        "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
                R.drawable.tvshow_gotham,
                "September 22, 2014",
                "69",
                "https://youtu.be/0d1zpt6k5OI",
                listOf(
                    FeaturedCrew(
                        "Bruno Heller",
                        "Creator"
                    )
                )
            )
        )

        tvShows.add(
            TvShowModel(
                9,
                "Grey's Anatomy",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                R.drawable.tvshow_grey_anatomy,
                "March 27, 2005",
                "62",
                "https://youtu.be/q1pcpgREQ5c",
                listOf(
                    FeaturedCrew(
                        "Shonda Rhimes",
                        "Creator"
                    )
                )
            )
        )

        tvShows.add(
            TvShowModel(
                10,
                "Hanna",
                "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
                R.drawable.tvshow_hanna,
                "March 28, 2019",
                "64",
                "https://youtu.be/wp6myRLnhAs",
                listOf(
                    FeaturedCrew(
                        "David Farr",
                        "Creator"
                    )
                )
            )
        )

        tvShows.add(
            TvShowModel(
                11,
                "Marvel's Iron Fist",
                "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny.",
                R.drawable.tvshow_iron_fist,
                "March 17, 2017",
                "61",
                "https://youtu.be/QCSPda7xQ3s",
                listOf(
                    FeaturedCrew(
                        "Scott Buck",
                        "Creator"
                    )
                )
            )
        )

        tvShows.add(
            TvShowModel(
                12,
                "Naruto Shippūden",
                "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki.",
                R.drawable.tvshow_naruto_shipudden,
                "February 15, 2007",
                "75",
                "https://youtu.be/1WLO0Owi5-A",
                listOf(
                    FeaturedCrew("", "")
                )
            )
        )

        tvShows.add(
            TvShowModel(
                13,
                "NCIS",
                "From murder and espionage to terrorism and stolen submarines, a team of special agents investigates any crime that has a shred of evidence connected to Navy and Marine Corps personnel, regardless of rank or position.",
                R.drawable.tvshow_ncis,
                "September 23, 2003",
                "67",
                "https://youtu.be/VzSsxINwIVE",
                listOf(
                    FeaturedCrew(
                        "Don McGill",
                        "Creator"
                    ),
                    FeaturedCrew(
                        "Donald P. Bellisario",
                        "Creator"
                    )
                )
            )
        )

        tvShows.add(
            TvShowModel(
                14,
                "Riverdale",
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                R.drawable.tvshow_riverdale,
                "January 26, 2017",
                "69",
                "https://youtu.be/9XmFTADupMc",
                listOf(
                    FeaturedCrew(
                        "Roberto Aguirre-Sacasa",
                        "Creator"
                    )
                )
            )
        )

        tvShows.add(
            TvShowModel(
                15,
                "Shameless",
                "Chicagoan Frank Gallagher is the proud single dad of six smart, industrious, independent kids, who without him would be... perhaps better off. When Frank's not at the bar spending what little money they have, he's passed out on the floor. But the kids have found ways to grow up in spite of him. They may not be like any family you know, but they make no apologies for being exactly who they are.",
                R.drawable.tvshow_shameless,
                "January 9, 2011",
                "78",
                "https://youtu.be/CHstRRD_8LE",
                listOf(
                    FeaturedCrew(
                        "Paul Abbott",
                        "Creator"
                    )
                )
            )
        )

        tvShows.add(
            TvShowModel(
                16,
                "Supergirl",
                "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism.",
                R.drawable.tvshow_supergirl,
                "October 26, 2015",
                "58",
                "https://youtu.be/Mh8MYFadTmQ",
                listOf(
                    FeaturedCrew(
                        "Greg Berlanti",
                        "Creator"
                    ),
                    FeaturedCrew(
                        "Andrew Kreisberg",
                        "Creator"
                    ),
                    FeaturedCrew(
                        "Ali Adler",
                        "Creator"
                    )
                )
            )
        )

        tvShows.add(
            TvShowModel(
                17,
                "Supernatural",
                "When they were boys, Sam and Dean Winchester lost their mother to a mysterious and demonic supernatural force. Subsequently, their father raised them to be soldiers. He taught them about the paranormal evil that lives in the dark corners and on the back roads of America ... and he taught them how to kill it. Now, the Winchester brothers crisscross the country in their '67 Chevy Impala, battling every kind of supernatural threat they encounter along the way.",
                R.drawable.tvshow_supernatural,
                "September 13, 2005",
                "73",
                "https://youtu.be/yy96yJjkvjo",
                listOf(
                    FeaturedCrew(
                        "Eric Kripke",
                        "Creator"
                    )
                )
            )
        )

        tvShows.add(
            TvShowModel(
                18,
                "The Simpsons",
                "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
                R.drawable.tvshow_the_simpson,
                "December 17, 1989",
                "71",
                "https://youtu.be/DX1iplQQJTo",
                listOf(
                    FeaturedCrew(
                        "Matt Groening",
                        "Creator"
                    )
                )
            )
        )

        tvShows.add(
            TvShowModel(
                19,
                "The Umbrella Academy",
                "A dysfunctional family of superheroes comes together to solve the mystery of their father's death, the threat of the apocalypse and more.",
                R.drawable.tvshow_the_umbrella,
                "February 15, 2019",
                "77",
                "https://youtu.be/0DAmWHxeoKw",
                listOf(
                    FeaturedCrew(
                        "Steve Blackman",
                        "Creator"
                    )
                )
            )
        )

        tvShows.add(
            TvShowModel(
                20,
                "The Walking Dead",
                "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.",
                R.drawable.tvshow_the_walking_dead,
                "October 31, 2010",
                "73",
                "https://youtu.be/R1v0uFms68U",
                listOf(
                    FeaturedCrew(
                        "Frank Darabont",
                        "Creator"
                    )
                )
            )
        )
        return tvShows
    }

    fun movieDetail(id: Int): MovieModel? {
        return generateMovies()[id - 1]
    }

    fun tvShowDetail(id: Int): TvShowModel? {
        return generateTvShow()[id - 1]
    }
}