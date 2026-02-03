const API_URL = "http://localhost:8080/reservas";

const form = document.getElementById("form-reserva");
const tabela = document.getElementById("tabela-reservas");
const aviso = document.getElementById("aviso");

async function carregarReservas() {
    const response = await fetch(API_URL);
    const reservas = await response.json();

    tabela.innerHTML = "";
    reservas.forEach(r => renderLinha(r));
}

function renderLinha(r, destaque = false) {
    const tr = document.createElement("tr");
    if (destaque) tr.classList.add("linha-destaque");

    tr.innerHTML = `
        <td>${r.nomeDoCliente}</td>
        <td>${r.dataDaFesta}</td>
        <td>${r.diaDaSemana}</td>
        <td>R$ ${r.valorDoSinal}</td>
        <td>R$ ${r.valorRestante}</td>
        <td>
            <button onclick="editar(${r.id})">Editar</button>
            <button onclick="excluir(${r.id})">Excluir</button>
        </td>
    `;

    tabela.appendChild(tr);
}

form.addEventListener("submit", async (e) => {
    e.preventDefault();
    aviso.textContent = "";

    const reserva = {
        dataDaFesta: dataDaFesta.value,
        nomeDoCliente: nomeDoCliente.value,
        diaDaSemana: diaDaSemana.value,
        valorDoSinal: valorDoSinal.value,
        valorRestante: valorRestante.value
    };

    try {
        const response = await fetch(API_URL, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(reserva)
        });

        if (!response.ok) {
            aviso.textContent = "🔔 Data já reservada!";
            return;
        }

        form.reset();
        carregarReservas();

    } catch {
        aviso.textContent = "Erro ao salvar reserva";
    }
});

async function buscarReservas() {
    const data = buscarData.value;
    if (!data) return;

    const response = await fetch(`${API_URL}/buscar?data=${data}`);
    const reservas = await response.json();

    tabela.innerHTML = "";

    if (reservas.length === 0) {
        aviso.textContent = "Nenhuma reserva para essa data";
        return;
    }

    aviso.textContent = "📅 Data já reservada!";
    reservas.forEach(r => renderLinha(r, true));

    document.getElementById("tabela-container")
        .scrollIntoView({ behavior: "smooth" });
}

async function editar(id) {
    const r = await fetch(`${API_URL}/${id}`).then(res => res.json());

    reservaId.value = r.id;
    dataDaFesta.value = r.dataDaFesta;
    nomeDoCliente.value = r.nomeDoCliente;
    diaDaSemana.value = r.diaDaSemana;
    valorDoSinal.value = r.valorDoSinal;
    valorRestante.value = r.valorRestante;
}

async function excluir(id) {
    if (confirm("Deseja excluir esta reserva?")) {
        await fetch(`${API_URL}/${id}`, { method: "DELETE" });
        carregarReservas();
    }
}

carregarReservas();
