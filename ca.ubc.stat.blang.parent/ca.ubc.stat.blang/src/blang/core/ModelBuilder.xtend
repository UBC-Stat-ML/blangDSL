package blang.core

@FunctionalInterface // Use to ensure uniqueDeclaredMethod will work
interface ModelBuilder {
  def Model build()
}