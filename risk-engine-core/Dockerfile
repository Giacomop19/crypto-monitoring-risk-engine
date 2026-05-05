FROM rust:latest

# Install required system dependencies
RUN apt-get update && apt-get install -y \
    pkg-config \
    libssl-dev \
    cmake \
    build-essential \
    zlib1g-dev

WORKDIR /app

COPY . .

RUN cargo build --release

CMD ["./target/release/risk-engine-core"]