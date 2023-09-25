// HTML이 로드된 후 실행되는 JavaScript 코드
document.addEventListener('DOMContentLoaded', function () {
  // 'td.table-content'와 'a.table-content' 요소를 모두 선택합니다.
  var cells = document.querySelectorAll('td.table-content, a.table-content');

  // 각 요소에 대해 처리합니다.
  cells.forEach(function (cell) {
    // 셀 내용을 가져옵니다.
    var cellContent = cell.innerText;

    // 셀 내용이 10자 이상인 경우 "..."으로 대체합니다.
    if (cellContent.length > 20) {
      cell.innerText = cellContent.substring(0, 20) + '...';
    }
  });
});

// HTML이 로드된 후 실행되는 JavaScript 코드
document.addEventListener('DOMContentLoaded', function () {
  // 'td.table-title' 요소를 선택합니다.
  var titleCells = document.querySelectorAll('td.table-title, a.table-title');

  // 각 요소에 대해 처리합니다.
  titleCells.forEach(function (cell) {
    // 셀 내용을 가져옵니다.
    var cellContent = cell.innerText;

    // 셀 내용이 8글자 이상인 경우 "..."으로 대체합니다.
    if (cellContent.length > 10) {
      cell.innerText = cellContent.substring(0, 10) + '...';
    }
  });
});