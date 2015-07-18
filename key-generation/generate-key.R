df <- read.csv('List of all nodes by type tabular.csv', stringsAsFactors = FALSE)

# first some munging to get format of each column exactly right!

df$node.ID <- tolower(df$node.ID)
df$node.ID <- paste(':', df$node.ID, sep='')

df$answer.1.ID <- tolower(df$answer.1.ID)
df$answer.1.ID <- paste(':', df$answer.1.ID, sep='')

df$answer.2.ID <- tolower(df$answer.2.ID)
df$answer.2.ID <- paste(':', df$answer.2.ID, sep='')

# define type
df['type'] <- sapply(df$answer.1.text, function(txt) if(txt==''){return('answer')}else{return('question')})

# define path by parents
df$parent.path <- tolower(df$parent.path)
df$parent.path <- gsub(", ", " :", df$parent.path)
df$parent.path <- paste(':', df$parent.path, sep='')

# first node has empty path
df[df$node.ID==':c1','parent.path'] <- ''

# subdivide in questions and answers
questions <- df[df$type=='question',]
answers <- df[df$type=='answer',]

# question clojure key format

# :c1 {
#   :question "Is there an external shell?"
#   :image-answer1 ""
#   :image-answer2 ""
#   :children [:ce1 "No" :c2 "Yes"]
#   :path []
#   :type "question"
# }

printQuestion <- function(xr){
  if(is.na(xr$answer.1.image)){ xr$answer.1.image <- ' '}
  if(is.na(xr$answer.2.image)){ xr$answer.2.image <- ' '}
  
  string <- paste(
    xr$node.ID, ' { ',
    ':question "', xr$node.text, '" ', # will be node.app.text in final version
    ':image-answer1 "', xr$answer.1.image, '" ',
    ':image-answer2 "', xr$answer.2.image, '" ',
    ':children [', xr$answer.1.ID, ' "', xr$answer.1.text, '" ', xr$answer.2.ID, ' "', xr$answer.2.text, '"] ',
    ':path [', xr$parent.path, '] ',
    ':type "question" }', sep=''
      )
  return(string)
}

# :ce1 {
#   :answer "Slug! Exit."
#   :image
#   :path [:c1]
#   :type "answer"
# }

printAnswer <- function(xr){
  if(is.na(xr$node.image..if.only.one.)){xr$node.image..if.only.one.<-''}
  string <- paste(
    xr$node.ID, ' { ',
    ':answer "', xr$node.text, '" ', # will be node.app.text in final version
    ':image "', xr$node.image..if.only.one., '" ',
    ':path [', xr$parent.path, '] ',
    ':type "answer" }', sep=''
  )
  return(string)
}

questionsStrings <- sapply(1:nrow(questions), function(i) return(printQuestion(questions[i,])))
answersStrings <- sapply(1:nrow(answers), function(i) return(printAnswer(answers[i,])))

resultFrame <- c('(def snail-key-flat {', questionsStrings, answersStrings, '})')
write(resultFrame, file='out.txt')

