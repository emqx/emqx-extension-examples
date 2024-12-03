fn main() {
    tonic_build::compile_protos("proto/exhook.proto").expect("Failed to compile proto files");
}
