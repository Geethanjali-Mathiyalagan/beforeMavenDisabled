var columns = [
	{ id: "apply", name: "Apply Now", field: "apply", formatter: linkFormatter }
];

var data = [
	{ id: 1, name: "Apply",field:1},

];

function linkFormatter() {
		return "<a href='/apply'>Apply Now</a>";
}

var options = {
	enableCellNavigation: true,
	enableColumnReorder: false
};

var grid = new Slick.Grid("#myGrid", data, columns, options);
