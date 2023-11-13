const Hls = require("hls.js");

var video = document.getElementById("video-player");
var videoUrl = "http://localhost:5000/cdn/hls/lw-identidade/output.m3u8";

if (Hls.isSupported()) {
  const hls = new Hls();
  hls.loadSource(videoUrl);
  hls.attachMedia(video);
  hls.on(Hls.Events.MANIFEST_PARSED, function () {
    // Aqui você pode acessar as diferentes qualidades disponíveis
    var availableQualities = hls.levels.map(function (level) {
      return level.height;
    });
    
      var videoListURL = "http://127.0.0.1:5000/content-names";
      var avaliableVideos = fetch(videoListURL, { method: "GET" }).then(
        (res) => res.body
      );

      function creteElements() {
        var videoSelector = document.createElement("select");
        avaliableVideos.forEach(function (video) {
          var option = document.createElement("option");
          option.value = video;
          option.text = video;
          videoSelector.appendChild(option);
        });
      }

    // Crie um seletor de qualidade e adicione as opções
    var qualitySelector = document.createElement("select");
    availableQualities.forEach(function (quality) {
      var option = document.createElement("option");
      option.value = quality;
      option.text = quality + "p";
      qualitySelector.appendChild(option);
    });

    // Adicione um ouvinte de evento para trocar a qualidade
    qualitySelector.addEventListener("change", function () {
      var selectedQuality = qualitySelector.value;
      hls.levels.forEach(function (level, levelIndex) {
        if (level.height == selectedQuality) {
          hls.currentLevel = levelIndex;
        }
      });
    });

    // Adicione o seletor de qualidade ao DOM
    document.body.appendChild(qualitySelector);
  });
}
