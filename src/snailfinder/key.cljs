(ns snailfinder.key)

(def snail-key-flat
  {
   :a1   {:question "Is the shell taller than it is wide (i.e. long and thin) or round and flat / globular [Generic long and thin Ena montana vs. round flat / globular Arianta arbustorum]" :children {:a2 {:answer "Long & Thin" :image ""} :a3 {:answer "Round / Globular" :image ""}} :path [:c1 :c2] :type :question}
   :a2   {:question "Does the mouth have teeth or not? [Picture of Gulella io with teeth vs. generic Subulinidae]" :children {:ae2 {:answer "Teeth" :image ""} :ae3 {:answer "No Teeth" :image ""}} :path [:c1 :c2 :a1] :type :question}
   :a3   {:question " Is the shell a pyramid shape or more flat? [insert picture of Kaliella barrakporensis vs a generic mix of Helicodiscidae / Pleurodiscidae / Gastrodontidae Hothouse alien species]" :children {:a4 {:answer "Flat" :image ""} :ae1 {:answer "Pyramid" :image ""}} :path [:c1 :c2 :a1] :type :question}
   :a4   {:question "Is the shell bigger than 3mm wide and long or smaller than that? [Insert generic pictures of flat snails with one bigger / wider than the others plus a ruler]" :children {:a5 {:answer "Bigger" :image ""} :a6 {:answer "Smaller" :image ""}} :path [:c1 :c2 :a1 :a3] :type :question}
   :a5   {:question "Is the shell ribbed or not? [Insert pictures of Pleurodiscus balmei and Zonitoides arboreus]" :children {:ae4 {:answer "Ribbed" :image ""} :ae5 {:answer "Not Ribbed" :image ""}} :path [:c1 :c2 :a1 :a3 :a4] :type :question}
   :a6   {:question "Does the shell have horizontal striations? [Insert pictures of Hawaiia minuscula and Helicodiscus parallelus]" :children {:ae7 {:answer "Yes" :image ""} :ae6 {:answer "No" :image ""}} :path [:c1 :c2 :a1 :a3 :a4] :type :question}
   :b1   {:question "Is the shell clearly wider than it is tall (i.e. flat) or not? [generic image of a Discus rotundatus vs generic picture of something like a Cornu aspersum]" :children {:b7 {:answer "Flat" :image ""} :b2 {:answer "Not Flat" :image ""}} :path [:c1 :c2 :c3] :type :question}
   :b2   {:question "Is the shell a pyramid shape or more “globular” [insert picture of Trochoidea elegans vs something like Helix lucorum]" :children {:b3 {:answer "Pyramid" :image ""} :b5 {:answer "Not Pyramid - Globular" :image ""}} :path [:c1 :c2 :c3 :b1] :type :question}
   :b3   {:question "Is the shell big or small (GIVE DIMENSIONS GUIDE?)?" :children {:be10 {:answer "Big" :image ""} :b4 {:answer "Small" :image ""}} :path [:c1 :c2 :c3 :b1 :b2] :type :question}
   :b4   {:question "Is the umbilicus wide or narrow [generic picture of Pyramidulidae and Euconulidae umbilici]" :children {:be11 {:answer "Wide" :image ""} :be12 {:answer "Narrow" :image ""}} :path [:c1 :c2 :c3 :b1 :b2 :b3] :type :question}
   :b5   {:question "Is the shell smaller than 1cm wide or bigger than 1cm wide? [generic pictures of bigger snail being Helix lucorum and smaller being Spermodea lamellata, plus ruler]" :children {:b6 {:answer "Smaller" :image ""} :be13 {:answer "Bigger" :image ""}} :path [:c1 :c2 :c3 :b1 :b2] :type :question}
   :b6   {:question "Is the shell spiney or ribbed? [Pictures of Acanthinula aculeata and Spermodea lamellata]" :children {:be8 {:answer "Spiney" :image ""} :be9 {:answer "Ribbed" :image ""}} :path [:c1 :c2 :c3 :b1 :b2 :b5] :type :question}
   :b7   {:question "Is the shell bigger / longer than 1cm or smaller / shorter than 1cm? [Picture of generic flat shells with rulers, one longer than the other]" :children {:b8 {:answer "Smaller" :image ""} :b12 {:answer "Bigger / Longer" :image ""}} :path [:c1 :c2 :c3 :b1] :type :question}
   :b8   {:question "Is the shell less than 3mm long or more than 3mm long? [Generic picture of flat shells plus ruler, one longer than the other]" :children {:be1 {:answer "More" :image ""} :b9 {:answer "Less" :image ""}} :path [:c1 :c2 :c3 :b1 :b7] :type :question}
   :b9   {:question "Is the shell ribbed or not? [Generic picture of exaggerated ribs of Discus rotundas vs. smooth Pristilomatidae species]" :children {:b10 {:answer "Ribbed" :image ""} :b11 {:answer "Not Ribbed" :image ""}} :path [:c1 :c2 :c3 :b1 :b7 :b8] :type :question}
   :b10  {:question "Which of these two snails looks like your one? [Pictures of Paralaoma servilis and Discus rotundatus]" :children {:be2 {:answer "(picture paralaoma)" :image ""} :be3 {:answer "(picture discus rotundatus)" :image ""}} :path [:c1 :c2 :c3 :b1 :b7 :b8 :b9] :type :question}
   :b11  {:question "Does the shell have a small or a wide umbilicus? [Pictures of generic wide vs small umbilici]" :children {:be4 {:answer "Small Umbilicus" :image ""} :be5 {:answer "Wide Umbilicus" :image ""}} :path [:c1 :c2 :c3 :b1 :b7 :b8 :b9] :type :question}
   :b12  {:question "Has the shell got a sharp keel and does it look a bit like a flying saucer? [Picture of Helicigona lapicida, and generic picture of a rounder shell like a Oxychilius cellarius]" :children {:be15 {:answer "Yes" :image ""} :b13 {:answer "No" :image ""}} :path [:c1 :c2 :c3 :b1 :b7] :type :question}
   :b13  {:question "Is the shell clearly stripey or not? [Picture of Helicella itala vs less obvious stripes of Candidula / smooth Oxychilius cellarius]" :children {:be16 {:answer "Stripey" :image ""} :b14 {:answer "Not Stripey" :image ""}} :path [:c1 :c2 :c3 :b1 :b7 :b12] :type :question}
   :b14  {:question "Is the shell hairy and tightly coiled or not? [Picture of hairy Helicodonta obvoluta and not hairy Oxychilus / Candidula]" :children {:be14 {:answer "Hairy" :image ""} :b15 {:answer "Not Hairy" :image ""}} :path [:c1 :c2 :c3 :b1 :b7 :b12 :b13] :type :question}
   :b15  {:question "Is the shell flat and smooth or ribbed? [Pictures of smooth Oxychilus and ribbed Candidula]" :children {:be6 {:answer "Smooth" :image ""} :be7 {:answer "Ribbed" :image ""}} :path [:c1 :c2 :c3 :b1 :b7 :b12 :b13 :b14] :type :question}
   :c1   {:question "Is there an external shell? [Generic picture of a slug (N) and snail (Y)]" :children {:ce1 {:answer "No" :image "C1_CE1_Slugs.jpg"} :c2 {:answer "Yes" :image "C1_C2_Snails.jpg"}} :path [] :type :question}
   :c2   {:question "Are you in a greenhouse or hothouse, and did you find your snail there? [Picture for a greenhouse, and picture for not]" :children {:a1 {:answer "Hothouse" :image ""} :c3 {:answer "Not Hothouse" :image ""}} :path [:c1] :type :question}
   :c3   {:question " Is the shell taller than it is wide (i.e. long and thin), or round and globular looking? [pictures of generic long and thin (Ena montana), and round flat / globular (Arianta arbustorum)]" :children {:b1 {:answer "Round" :image "C3_CB1_RoundAndFat.jpg"} :c4 {:answer "Long & Thin" :image "C3_C4_LongAndThin.jpg"}} :path [:c1 :c2] :type :question}
   :c4   {:question "Does the shell point to the left (sinistral) or to the right (dextral)? [Use pictures of Ena montana for right / dextral and Cochlodina laminata for left / sinistral]" :children {:c5 {:answer "Left" :image "C4_C5_LongThinSinistralLeft.jpg"} :c7 {:answer "Right" :image "C4_C7_LongThinDextralRight.jpg"}} :path [:c1 :c2 :c3] :type :question}
   :c5   {:question "Is the shell large and needle-like, or very small and dumpy? [Picture of generic Clausiliidae and generic Vertigo angustior]" :children {:ce20 {:answer "Large & Needle-like" :image ""} :c6 {:answer "Small & Dumpy" :image ""}} :path [:c1 :c2 :c3 :c4] :type :question}
   :c6   {:question "Does it have teeth? [Pictures of Vertigo angustior (no teeth) & Vertigo pusilla (teeth)" :children {:ce14 {:answer "No teeth" :image ""} :ce15 {:answer "Has teeth" :image ""}} :path [:c1 :c2 :c3 :c4 :c5] :type :question}
   :c7   {:question " Is the shell more than 3mm high or less than 3mm high? [Generic picture of right leaning long and thin shell one smaller and the other larger, plus ruler]" :children {:c9 {:answer "Less than 3mm" :image ""} :c8 {:answer "More than 3mm" :image ""}} :path [:c1 :c2 :c3 :c4] :type :question}
   :c8   {:question "Does the mouth have teeth or not [generic teeth or no teeth picture] - same page as for Q7" :children {:c10 {:answer "No teeth" :image "C8_C10_NoTeeth.jpg"} :ce4 {:answer "Has teeth" :image "C8_CE4_Teeth.jpg"}} :path [:c1 :c2 :c3 :c4 :c7] :type :question}
   :c9   {:question "Does the mouth have teeth or not [generic teeth or no teeth picture]" :children {:c16 {:answer "No teeth" :image "C9_C16_NoTeeth.jpg"} :c18 {:answer "Has teeth" :image "C9_C18_Teeth.jpg"}} :path [:c1 :c2 :c3 :c4 :c7] :type :question}
   :c10  {:question "Does the mouth have an operculum? [Draw generic picture of Pomatias elegans with operculum and snail with no operculum]" :children {:ce5 {:answer "Has operculum" :image ""} :c11 {:answer "No operculum" :image ""}} :path [:c1 :c2 :c3 :c4 :c7 :c8] :type :question}
   :c11  {:question "Does the shell have few flattened whorls or not? [picture of Oxyloma elegans and a generic picture of a mix of Cochlicopidae / Enidae / Cochlicellidae]" :children {:ce6 {:answer "Few flattened whorls" :image ""} :c12 {:answer "No whorls" :image ""}} :path [:c1 :c2 :c3 :c4 :c7 :c8 :c10] :type :question}
   :c12  {:question "Does the mouth have a thickened lip or not? [picture of thick lip of Ena montana vs Cochlicopidae / Cochlicellidae small lip]" :children {:c14 {:answer "No thick lip" :image ""} :c13 {:answer "Thick lip" :image ""}} :path [:c1 :c2 :c3 :c4 :c7 :c8 :c10 :c11] :type :question}
   :c13  {:question " Is the shell big or small? [pictures of large Ena montana and small Merdigera obscura]" :children {:ce11 {:answer "Small" :image ""} :ce12 {:answer "Large" :image ""}} :path [:c1 :c2 :c3 :c4 :c7 :c8 :c10 :c11 :c12] :type :question}
   :c14  {:question "Is the shell smooth and glossy or not? [generic pictures of Cochlicopidae vs Cochlicellidae]" :children {:ce7 {:answer "Smooth & glossy" :image ""} :c15 {:answer "Not" :image ""}} :path [:c1 :c2 :c3 :c4 :c7 :c8 :c10 :c11 :c12] :type :question}
   :c15  {:question "Is the shell long and tall or dumpy and fat? [Pictures of Cochlicella acuta vs Cochlicella barbara]" :children {:ce10 {:answer "Dumpy & fat" :image ""} :ce13 {:answer "Long & Tall" :image ""}} :path [:c1 :c2 :c3 :c4 :c7 :c8 :c10 :c11 :c12 :c14] :type :question}
   :c16  {:question "Is the shell extremely narrow (no wider than 1.5mm) or fatter than that? [picture of Ceciliodes acicula and a generic fatter pupilla muscorum]" :children {:c17 {:answer "Fatter" :image ""} :ce16 {:answer "Narrow" :image ""}} :path [:c1 :c2 :c3 :c4 :c7 :c9] :type :question}
   :c17  {:question "Is the shell more like a narrow cylinder with vertical ridges or slightly fatter? [generic pictures of Acicula fusca or generic fatter pupilla muscorum]" :children {:ce17 {:answer "Narrow" :image ""} :ce19 {:answer "Fatter" :image ""}} :path [:c1 :c2 :c3 :c4 :c7 :c9 :c16] :type :question}
   :c18  {:question "Is the shell very small and slender or not? [generic picture of Carychium tridentatum vs lauriidae]" :children {:ce8 {:answer "Small & Slender" :image ""} :ce9 {:answer "Not" :image ""}} :path [:c1 :c2 :c3 :c4 :c7 :c9] :type :question}
   :ae1  {:answer "Kaliella barrakporensis (CHRONIDAE)" :image "" :path [:c1 :c2 :a1 :a3] :endpoints [] :type :species}
   :ae2  {:answer "Gulella io (STREPTAXIDAE)" :image "" :path [:c1 :c2 :a1 :a2] :endpoints [] :type :species}
   :ae3  {:answer "SUBULINIDAE" :image "" :path [:c1 :c2 :a1 :a2] :endpoints [] :type :family}
   :ae4  {:answer "Pleurodiscus balmei (PLEURODISCIDAE)" :image "" :path [:c1 :c2 :a1 :a3 :a4 :a5] :endpoints [] :type :species}
   :ae5  {:answer "Zonitoides arboreus (GASTRODONTIDAE)" :image "" :path [:c1 :c2 :a1 :a3 :a4 :a5] :endpoints [] :type :species}
   :ae6  {:answer "Hawaiia minuscula (PRISTILOMATIDAE)" :image "" :path [:c1 :c2 :a1 :a3 :a4 :a6] :endpoints [] :type :species}
   :ae7  {:answer "Helicodiscus parallelus (HELICODISCIDAE)" :image "" :path [:c1 :c2 :a1 :a3 :a4 :a6] :endpoints [] :type :species}
   :be1  {:answer "Cluster of: OXYCHILIDAE x 5 (Aegopinella pura, Nesovitrea hammonis, Aegopinella nitidula, Oxychilus navarricus helveticus, Oxychilus alliarius), and HYGROMIDAE x 7 (Zenobiella subrufescens, Trochulus x 3, Hygromia cinctella and Ashfordia granulata)" :image "" :path [:c1 :c2 :c3 :b1 :b7 :b8] :endpoints [] :type :cluster}
   :be2  {:answer "Paralaoma servilis (PUNCTIDAE 1)" :image "" :path [:c1 :c2 :c3 :b1 :b7 :b8 :b9 :b10] :endpoints [] :type :species}
   :be3  {:answer "Discus rotundatus (DISCIDAE)" :image "" :path [:c1 :c2 :c3 :b1 :b7 :b8 :b9 :b10] :endpoints [] :type :species}
   :be4  {:answer "PRISTILOMATIDAE" :image "" :path [:c1 :c2 :c3 :b1 :b7 :b8 :b9 :b11] :endpoints [] :type :family}
   :be5  {:answer "Cluster of: Punctum pygmaeum (PUNCTIDAE 2), HELICODISCIDAE (one species Lucilla singleyana), and GASTRODONTIDAE (Zonitoides x 2)" :image "" :path [:c1 :c2 :c3 :b1 :b7 :b8 :b9 :b11] :endpoints [] :type :cluster}
   :be6  {:answer "Oxychilus cellarius & Oxychilus draparnaudi (OXYCHILIDAE)" :image "" :path [:c1 :c2 :c3 :b1 :b7 :b12 :b13 :b14 :b15] :endpoints [] :type :species}
   :be7  {:answer "Profiles of Candidula intersecta & Candidula gigaxii (HYGROMIIDAE)" :image "" :path [:c1 :c2 :c3 :b1 :b7 :b12 :b13 :b14 :b15] :endpoints [] :type :cluster}
   :be8  {:answer "Acanthinula aculeata (VALLONIIDAE)" :image "" :path [:c1 :c2 :c3 :b1 :b2 :b5 :b6] :endpoints [] :type :species}
   :be9  {:answer "Spermodea lamellata (VALLONIIDAE)" :image "" :path [:c1 :c2 :c3 :b1 :b2 :b5 :b6] :endpoints [] :type :species}
   :be10 {:answer "Trochoidea elegans (HYGROMIIDAE)" :image "" :path [:c1 :c2 :c3 :b1 :b2 :b3] :endpoints [] :type :species}
   :be11 {:answer "Pyramidula pusilla (PYRAMIDULIDAE)" :image "" :path [:c1 :c2 :c3 :b1 :b2 :b3 :b4] :endpoints [:s6] :type :species}
   :be12 {:answer "EUCONULIDAE" :image "" :path [:c1 :c2 :c3 :b1 :b2 :b3 :b4] :endpoints [] :type :family}
   :be13 {:answer "Cluster of HYGROMIIDAE: Cernuella x 2, Hygromia limbata, Ponentina subvirescens, Monacha x 2, and also HELICIDAE: Cepaea x 2, Arianta arbustorum, Helix x 2, Cornu aspersum, and Theba pisana" :image "" :path [:c1 :c2 :c3 :b1 :b2 :b5] :endpoints [] :type :cluster}
   :be14 {:answer "Helicodonta obvoluta (HELICODONTIDAE)" :image "" :path [:c1 :c2 :c3 :b1 :b7 :b12 :b13 :b14] :endpoints [] :type :species}
   :be15 {:answer "Helicigona lapicida (HELICIDAE)" :image "" :path [:c1 :c2 :c3 :b1 :b7 :b12] :endpoints [] :type :species}
   :be16 {:answer "Helicella itala (HYGROMIIDAE)" :image "" :path [:c1 :c2 :c3 :b1 :b7 :b12 :b13] :endpoints [] :type :species}
   :ce1  {:answer "SLUG! Exit" :image "ce1_slugLife.jpg" :path [:c1] :endpoints [] :type :cluster}
   :ce4  {:answer "Profiles of Azeca goodalli (AZECIDAE) or Abida secale (CHONDRINIDAE) to choose from" :image "" :path [:c1 :c2 :c3 :c4 :c7 :c8] :endpoints [:s1] :type :cluster}
   :ce5  {:answer "POMATIIDAE / Pomatias elegans" :image "" :path [:c1 :c2 :c3 :c4 :c7 :c8 :c10] :endpoints [:s5] :type :species}
   :ce6  {:answer "SUCCINEIDAE" :image "" :path [:c1 :c2 :c3 :c4 :c7 :c8 :c10 :c11] :endpoints [] :type :family}
   :ce7  {:answer "COCHLICOPIDAE" :image "" :path [:c1 :c2 :c3 :c4 :c7 :c8 :c10 :c11 :c12 :c14] :endpoints [] :type :family}
   :ce8  {:answer "ELLOBIIDAE" :image "" :path [:c1 :c2 :c3 :c4 :c7 :c9 :c18] :endpoints [:s3 :s4] :type :family}
   :ce9  {:answer "Cluster of Leiostyla anglica & Lauria cylindracea (LAURIIDAE), and VERTIGINIDAE (7 species, not whole family - CHECK WHICH & WITH TOM)" :image "" :path [:c1 :c2 :c3 :c4 :c7 :c9 :c18] :endpoints [] :type :cluster}
   :ce10 {:answer "Cochlicella barbara (COCHLICELLIDAE)" :image "" :path [:c1 :c2 :c3 :c4 :c7 :c8 :c10 :c11 :c12 :c14 :c15] :endpoints [] :type :species}
   :ce11 {:answer "Merdigera obscura (ENIDAE)" :image "" :path [:c1 :c2 :c3 :c4 :c7 :c8 :c10 :c11 :c12 :c13] :endpoints [] :type :species}
   :ce12 {:answer "Ena montana (ENIDAE)" :image "" :path [:c1 :c2 :c3 :c4 :c7 :c8 :c10 :c11 :c12 :c13] :endpoints [] :type :species}
   :ce13 {:answer "Cochlicella acuta (COCHLICELLIDAE)" :image "" :path [:c1 :c2 :c3 :c4 :c7 :c8 :c10 :c11 :c12 :c14 :c15] :endpoints [] :type :species}
   :ce14 {:answer "Vertigo angustior (VERTIGINIDAE)" :image "" :path [:c1 :c2 :c3 :c4 :c5 :c6] :endpoints [] :type :species}
   :ce15 {:answer "Vertigo pusilla (VERTIGINIDAE)" :image "" :path [:c1 :c2 :c3 :c4 :c5 :c6] :endpoints [] :type :species}
   :ce16 {:answer "Cecilioides acicula (FERUSSACIIDAE)" :image "" :path [:c1 :c2 :c3 :c4 :c7 :c9 :c16] :endpoints [] :type :species}
   :ce17 {:answer "Acicula fusca (ACICULIDAE)" :image "" :path [:c1 :c2 :c3 :c4 :c7 :c9 :c16 :c17] :endpoints [:s2] :type :species}
   :ce19 {:answer "Cluster of PUPILLIDAE family (both 2 species), Lauria sempronii (LAURIIDAE), and VERTIGINIDAE (6 species, not whole family - CHECK WHICH WITH TOM)" :image "" :path [:c1 :c2 :c3 :c4 :c7 :c9 :c16 :c17] :endpoints [] :type :cluster}
   :ce20 {:answer "CLAUSILIIDAE" :image "" :path [:c1 :c2 :c3 :c4 :c5] :endpoints [] :type :family}
   })


