<header>
    <!-- Image and text -->
	<nav class="navbar navbar-expand-md navbar-dark bg-dark"> <a
		class="navbar-brand" href="#"> <img src="${images}/logo.jpg"
		width="120" height="40" class="d-inline-block align-top" alt="">
	</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNav" aria-controls="navbarNav"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarNav">
		<ul class="navbar-nav ml-auto">
			<li class="nav-item active"><a class="nav-link" href="#">Login
					& Signup</a></li>
			   <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          More
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="#">Sell on Ecommerce</a>
          <a class="dropdown-item" href="#">Contact Us</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="#">Something else here</a>
        </div>
      </li>
			<li class="nav-item"><a class="nav-link" href="#">Cart</a></li>
		</ul>
	</div>

	</nav>

	<nav class="navbar navbar-expand d-flex justify-content-around secondmain-navbar">
		<ul class="nav navbar-nav">
			<c:forEach items="${categories}" var="category">
			<li class="nav-item active">
				<a class="nav-link" href="category/${category.categoryId}">${category.categoryName}</a>
			</li>
			</c:forEach>
			<li class="nav-item">
				<a class="nav-link" href="#">Offer Zone</a>
			</li>
			
		</ul>
	</nav>
</header>