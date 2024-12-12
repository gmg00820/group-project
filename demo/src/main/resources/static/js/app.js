const BASE_URL = "http://localhost:8080/auth";

async function login() {
    const username = document.getElementById("login-username").value;
    const password = document.getElementById("login-password").value;

    try {
        const response = await fetch(`${BASE_URL}/signin`, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ username, password })
        });

        if (response.ok) {
            const data = await response.json();
            alert("로그인 성공! 토큰: " + data.token);
        } else {
            const error = await response.json();
            alert("로그인 실패: " + error.error);
        }
    } catch (err) {
        alert("로그인 요청 중 오류 발생: " + err.message);
    }
}

async function signup() {
    const username = document.getElementById("signup-username").value;
    const password = document.getElementById("signup-password").value;
    const email = document.getElementById("signup-email").value;

    try {
        const response = await fetch(`${BASE_URL}/signup`, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ username, password, email })
        });

        if (response.ok) {
            alert("회원가입 성공!");
        } else {
            const error = await response.json();
            alert("회원가입 실패: " + error.error);
        }
    } catch (err) {
        alert("회원가입 요청 중 오류 발생: " + err.message);
    }
}

async function resetPassword() {
    const email = document.getElementById("reset-email").value;
    const newPassword = document.getElementById("new-password").value;

    try {
        const response = await fetch(`${BASE_URL}/reset-password?email=${email}&newPassword=${newPassword}`, {
            method: "POST",
        });

        if (response.ok) {
            alert("비밀번호가 성공적으로 변경되었습니다!");
        } else {
            const error = await response.json();
            alert("비밀번호 변경 실패: " + error.error);
        }
    } catch (err) {
        alert("비밀번호 변경 요청 중 오류 발생: " + err.message);
    }
}
