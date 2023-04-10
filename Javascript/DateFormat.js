const date= document.querySelectorAll('#date');
date.forEach(cell => {
  const dateParts = cell.innerText.split('-');
  const formattedDate = `${dateParts[2]}-${dateParts[1]}-${dateParts[0]}`;
  cell.innerText = formattedDate;
});
