package blang.core

@FunctionalInterface
interface ModelBuilder {
  def Model build()
}