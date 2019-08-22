<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

 <div layout:fragment="content">
    <h1>Error Page</h1>
    error code : <span th:text="${code}">${code}</span>
    <br>error msg : <span text="${msg}">${msg}</span>
    <br>timestamp : <span text="${timestamp}">${timestamp}</span>
  </div>
