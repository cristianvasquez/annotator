<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>JS annotation test</title>

    <!-- jQuery must be included before Annotator -->
    <script src="lib/vendor/jquery.js"></script>

    <!-- If you're sure your users will only be using browsers modern
         enough to have their own JSON.parse and JSON.stringify
         implementations you can skip this -->
    <script src="lib/vendor/json2.js"></script>

    <!-- The main Annotator script -->
    <script src="annotator-full.1.2.6/annotator-full.min.js"></script>

    <!-- Annotator's styling and images -->
    <link rel="stylesheet" type="text/css" href="annotator-full.1.2.6/annotator.min.css">
    
    <!-- Useful for The Markdown plugin. Treat annotation text as Markdown -->
    <script src="lib/vendor/showdown.js"></script>

  </head>

  <body>
    <header>
      <h1>Javascript annotation service test</h1>
    </header>

    <div id="airlock">

      <h2>The notion of annotation</h2>

		<p>Currently, there is no consensus about what an annotation is. 
		One of the most common definitions is that an annotation is an object that describes or says something about other object of information, constituting descriptive information of any type about objects.
		 Usually this is understood as a piece ``attached'' to other piece of information, but an annotation is not limited to that interpretation. 
		 We can also see the process of annotating as the process of building <b>relationships</b> between descriptions. 
		 We can note that this last interpretation of annotation is plausible since the annotations are objects of information which can be seen as equivalent to the objects being annotated; since they are both descriptions.
		</p>
		<p>
		To focus on relationships rather than in ``attached data'' is a convenient interpretation for some cases. 
		Particularly in this work we refer to descriptions and relations between information objects as the same. 
		</p>
		<p>
		Annotations can be hard to capture, yet worth to keep. It is unclear to a person creating an annotation, 
		when and in which context that particular annotation will be relevant again. Because of this uncertainty, 
		we want to keep contextual information in form of meta-data about the relationships between the descriptions. 
		Which contextual information is the best to use, remains an open question, 
		the most used are the five "who, what, when, where, how" or the "who, what, when, where, why" dimensions. 
		We will treat these ``associations'' as first class citizens, used to discover, understand and manage our stored objects, 
		exploiting annotation processes as the association of things, complementing 
		categorization or selecting resources to ``attach'' meta-data such as descriptions, properties, type etc. 
		We expect that focusing on the representation of ``associations'' instead of the attached 
		descriptions potentially will leverage the complexity of our underlying models that focus on personal data management. 
		For example, metadata about relationships can directly support associative browsing, where we can analyze and cluster the information to find related items.
		</p>
      <h3>Header Level 3</h3>

      <ul>
         <li id="listone">Lorem ipsum dolor sit amet, consectetuer adipiscing elit.</li>
         <li id="listtwo">Aliquam tincidunt mauris eu risus.</li>
      </ul>

      <pre><code>
      #header h1 a {
        display: block;
        width: 300px;
        height: 80px;
      }
      </code></pre>
    </div>

    <script>
    console.log("We are logging");
      jQuery(function ($) {
        if (typeof $.fn.annotator !== 'function') {
        	console.log("Ooops! it looks like you haven't ...");
          alert("Ooops! it looks like you haven't built the Annotator concatenation file. " +
                "Either download a tagged release from GitHub, or modify the Cakefile to point " +
                "at your copy of the YUI compressor and run `cake package`.");
        } else {
          // This is the important bit: how to create the annotator and add
          // plugins
          console.log("Inside Airlock ...");
                  
          var content = $('#airlock').annotator();
        
          content.annotator()
                       .annotator('addPlugin', 'Permissions')
                       .annotator('addPlugin', 'Markdown')
                       .annotator('addPlugin', 'Tags');

          content.annotator('addPlugin', 'Store', {
              // The endpoint of the store on your server.
              prefix: '/annotator/api',

              // Attach the uri of the current page to all annotations to allow search.
              annotationData: {
                'uri': 'http://this/document/only'
              },

              // This will perform a "search" action rather than "read" when the plugin
              // loads. Will request the last 20 annotations for the current url.
              // eg. /store/endpoint/search?limit=20&uri=http://this/document/only
              loadFromSearch: {
                'limit': 20,
                'uri': 'http://this/document/only'
              }
            });
          
          $('#airlock').data('annotator').plugins['Permissions'].setUser("Cristian");
          console.log("Cristian is online...");
          
        }
      });
    </script>
      	
  </body>

</html>
