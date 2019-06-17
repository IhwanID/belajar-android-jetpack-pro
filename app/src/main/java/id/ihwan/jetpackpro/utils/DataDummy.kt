package id.ihwan.jetpackpro.utils

import id.ihwan.jetpackpro.R
import id.ihwan.jetpackpro.movies.Movies
import id.ihwan.jetpackpro.tvshow.TvShow

object DataDummy {

    fun generateDummyMovies(): List<Movies> {

        return listOf(
                Movies(1,"Alita : Battle Angel","Robert Rodriguez", "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.", R.drawable.poster_alita, "2019", "67"),
                Movies(2,"Aquaman", "James Wan","Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.", R.drawable.poster_aquaman, "17 Agustus 1945", "9.5"),
                Movies(3,"Bohemian Rhapsody", "","lSinger Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.", R.drawable.poster_bohemian, "17 Agustus 1945", "9.5"),
                Movies(4,"Creed II","Steven Caple Jr.", "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.", R.drawable.poster_creed, "17 Agustus 1945", "9.5"),
                Movies(5,"The Crimes Of Grindelwald","David Yates", "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.", R.drawable.poster_crimes, "2018", "9.5"),
                Movies(6,"Glass","M. Night Shyamalan", "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.", R.drawable.poster_glass, "2019", "9.5"),
                Movies(7,"How To Train Your Dragon : The Hidden World", "Dean DeBlois","As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.", R.drawable.poster_how_to_train, "2019", "76"),
                Movies(8,"Avengers : Infinity War","Joe Russo", "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.", R.drawable.poster_infinity_war, "2018", "83"),
                Movies(9,"Master Z: Ip Man Legacy", "Yuen Woo-ping","After being defeated by Ip Man, Cheung Tin Chi is attempting to keep a low profile. While going about his business, he gets into a fight with a foreigner by the name of Davidson, who is a big boss behind the bar district. Tin Chi fights hard with Wing Chun and earns respect.", R.drawable.poster_master_z, "2018", "52"),
                Movies(10,"Mortal Engines","Christian Rivers", "Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom Natsworthy has an unexpected encounter with a mysterious young woman from the wastelands who will change the course of his life forever.", R.drawable.poster_mortal_engines, "17 Agustus 1945", "9.5"),
                Movies(11,"Overlord", "Yumi Hara","In the year 2138, virtual reality gaming is booming. Yggdrasil, a popular online game is quietly shut down one day. However, one player named Momonga decides to not log out. Momonga is then transformed into the image of a skeleton as \"the most powerful wizard.\" The world continues to change, with non-player characters (NPCs) beginning to feel emotion. Having no parents, friends, or place in society, this ordinary young man Momonga then strives to take over the new world the game has become.", R.drawable.poster_overlord, "2015", "75"),
                Movies(12,"Ralph Breaks The Internet","Phil Johnston", "Video game bad guy Ralph and fellow misfit Vanellope von Schweetz must risk it all by traveling to the World Wide Web in search of a replacement part to save Vanellope's video game, \"Sugar Rush.\" In way over their heads, Ralph and Vanellope rely on the citizens of the internet -- the netizens -- to help navigate their way, including an entrepreneur named Yesss, who is the head algorithm and the heart and soul of trend-making site BuzzzTube.", R.drawable.poster_ralph, "17 Agustus 1945", "9.5"),
                Movies(13,"Robin Hood","Ben Chandler", "A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English crown.", R.drawable.poster_robin_hood, "2018", "72"),
                Movies(14,"Serenity","Steven Knight", "Baker Dill is a fishing boat captain leading tours off a tranquil, tropical enclave called Plymouth Island. His quiet life is shattered, however, when his ex-wife Karen tracks him down with a desperate plea for help.", R.drawable.poster_serenity, "2019", "51"),
                Movies(15,"Spider-Man : Into The Spider-Verse", "Rodney Rothman","Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \"Kingpin\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension.", R.drawable.poster_spiderman, "2018", "9.5"),
                Movies(16,"T34","Aleksey Sidorov", "In 1944, a courageous group of Russian soldiers managed to escape from German captivity in a half-destroyed legendary T-34 tank. Those were the times of unforgettable bravery, fierce fighting, unbreakable love, and legendary miracles.", R.drawable.poster_t34, "2018", "9.5")
                )
    }

    fun generateDummyTvShow(): List<TvShow> {

        return listOf(
                TvShow(1,"Arrow", "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.", R.drawable.poster_arrow, "2012", "58"),
                TvShow(2,"Doom Patrol", "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.", R.drawable.poster_doom_patrol, "17 Agustus 1945", "9.5"),
                TvShow(3,"Dragon Ball", "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the dragon balls brought her to Goku's home. Together, they set off to find all seven dragon balls in an adventure that would change Goku's life forever. See how Goku met his life long friends Bulma, Yamcha, Krillin, Master Roshi and more. And see his adventures as a boy, all leading up to Dragonball Z and later Dragonball GT.", R.drawable.poster_dragon_ball, "17 Agustus 1945", "9.5"),
                TvShow(4,"Fairy Tail", "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.", R.drawable.poster_fairytail, "17 Agustus 1945", "9.5"),
                TvShow(5,"Family Guy", "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.", R.drawable.poster_family_guy, "17 Agustus 1945", "9.5"),
                TvShow(6,"The Flash", "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.", R.drawable.poster_flash, "17 Agustus 1945", "9.5"),
                TvShow(7,"Gotham", "Before there was Batman, there was GOTHAM.\n" +
                        "\n" +
                        "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?", R.drawable.poster_gotham, "17 Agustus 1945", "9.5"),
                TvShow(8,"Grey's Anatomy", "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.", R.drawable.poster_grey_anatomy, "17 Agustus 1945", "9.5"),
                TvShow(9,"Hanna", "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.", R.drawable.poster_hanna, "17 Agustus 1945", "9.5"),
                TvShow(10,"NCIS", "From murder and espionage to terrorism and stolen submarines, a team of special agents investigates any crime that has a shred of evidence connected to Navy and Marine Corps personnel, regardless of rank or position.", R.drawable.poster_ncis, "17 Agustus 1945", "9.5"),
                TvShow(11,"Riverdale", "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.", R.drawable.poster_riverdale, "17 Agustus 1945", "9.5"),
                TvShow(12,"Shameless", "Chicagoan Frank Gallagher is the proud single dad of six smart, industrious, independent kids, who without him would be... perhaps better off. When Frank's not at the bar spending what little money they have, he's passed out on the floor. But the kids have found ways to grow up in spite of him. They may not be like any family you know, but they make no apologies for being exactly who they are.", R.drawable.poster_shameless, "17 Agustus 1945", "9.5"),
                TvShow(13,"Supergirl", "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism.", R.drawable.poster_supergirl, "17 Agustus 1945", "9.5"),
                TvShow(14,"Supernatural", "When they were boys, Sam and Dean Winchester lost their mother to a mysterious and demonic supernatural force. Subsequently, their father raised them to be soldiers. He taught them about the paranormal evil that lives in the dark corners and on the back roads of America ... and he taught them how to kill it. Now, the Winchester brothers crisscross the country in their '67 Chevy Impala, battling every kind of supernatural threat they encounter along the way.", R.drawable.poster_supernatural, "17 Agustus 1945", "9.5"),
                TvShow(15,"The Simpson", "lorem ipsum", R.drawable.poster_the_simpson, "17 Agustus 1945", "9.5"),
                TvShow(16,"The Umbrella Academy", "A dysfunctional family of superheroes comes together to solve the mystery of their father's death, the threat of the apocalypse and more.", R.drawable.poster_the_umbrella, "17 Agustus 1945", "9.5"),
                TvShow(17,"The Walking Dead", "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.", R.drawable.poster_the_walking_dead, "2010", "73")
        )
    }

    fun getMoviesById(id : Int) : Movies? {

        for (i in 0 until generateDummyMovies().size) {
            val movies : Movies = generateDummyMovies()[i]
            if (movies.id == id) {
                return movies
            }
        }
        return null
    }

    fun getTvShowById(id : Int) : TvShow? {

        for (i in 0 until generateDummyMovies().size) {
            val tvShow : TvShow = generateDummyTvShow()[i]
            if (tvShow.id == id) {
                return tvShow
            }
        }
        return null
    }

}