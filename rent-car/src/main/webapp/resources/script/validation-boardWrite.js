$(document).ready(() => {
	const user = session.getAttribute("adminCheck");
	if(!user === "Y") {
		$('noticeCheck').hide();
	}
}); 