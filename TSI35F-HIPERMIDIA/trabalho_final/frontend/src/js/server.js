const http = require("http");
const fs = require("fs");
const path = require("path");

const server = http.createServer((req, res) => {
  // Define routes and corresponding file paths
  const routes = {
    "/": "dist/index.html",
    "/main.js": "dist/main.js",
  };

  const filePath = routes[req.url];

  // Check if the requested route exists
  if (filePath) {
    const fullPath = path.join(
      "/home/andre/Documents/Disciplinas-TSI/Sistemas Multimidia e Hipermidia/trabalho_final/frontend/",
      filePath
    );

    console.log(fullPath)

    // Read and serve the file
    fs.readFile(fullPath, (err, data) => {
      if (err) {
        res.statusCode = 500;
        res.end("Error loading the file");
      } else {
        // Determine the content type based on the file extension
        let contentType = "text/plain";
        if (filePath.endsWith(".html")) {
          contentType = "text/html";
        } else if (filePath.endsWith(".css")) {
          contentType = "text/css";
        } else if (filePath.endsWith(".js")) {
          contentType = "text/javascript";
        }

        res.statusCode = 200;
        res.setHeader("Content-Type", contentType);
        res.end(data);
      }
    });
  } else {
    // Route not found
    res.statusCode = 404;
    res.end("Route not found");
  }
});

server.listen(3000, () => {
  console.log("Server running at http://localhost:3000/");
});
