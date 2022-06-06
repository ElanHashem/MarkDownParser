for file in test-files/*.md;
do:wq
::
  echo $file
  java MarkdownParse $file
done
