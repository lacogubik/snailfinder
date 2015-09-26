rm(list=ls())
df <- read.csv('Hack Day Snail Endpoints.csv', stringsAsFactors = FALSE)

# first some munging to get format of each column exactly right!
df$node.ID <- tolower(df$node.ID)
df$node.ID <- paste(':', df$node.ID, sep='')

# :s1  {:name                      ""
#       :common-name               ""
#       :family                    ""
#       :size                      ""
#       :image                     ""
#       :identification-characters ""
#       :similar-species           ""
#       :ecology                   ""
#       :gb-distribution           ""
#       :world-distribution        ""
#       :conservation-status       ""
#       :map-image                 ""
#       :notes                     ""}

printEndpoint <- function(xr){
  if(is.na(xr$notes)){xr$notes<-''}
  if(is.na(xr$image)){xr$image<-''}
  if(is.na(xr$map.image)){xr$map.image<-''}
  string <- paste(
    xr$node.ID, ' { ',
    ':name "', xr$name, '" ',
    ':common-name "', xr$common.name, '" ',
    ':family "', xr$family, '" ',
    ':size "', xr$size, '" ',
    ':image "', xr$image, '" ',
    ':identification-characters "', xr$identification.characters, '" ',
    ':similar-species "', xr$similar.species, '" ',
    ':ecology "', xr$ecology, '" ',
    ':gb-distribution "', xr$distribution.in.the.British.Isles, '" ',
    ':world-distribution "', xr$distribution.elsewhere, '" ',
    ':conservation-status "', xr$conservation.status, '" ',
    ':map-image "', xr$map.image, '" ',
    ':notes "', xr$notes, '"}', sep=''
  )
  return(string)
}

endpointsStrings <- sapply(1:nrow(df), function(i) return(printEndpoint(df[i,])))

resultFrame <- c('(def snails {', endpointsStrings, '})')
write(resultFrame, file='snails-out.txt')

